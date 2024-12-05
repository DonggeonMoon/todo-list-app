import React, {useEffect, useState} from "react";
import ScheduleEditor from "@/components/ScheduleEditor";
import axios, {AxiosResponse} from "axios";
import {Schedule} from "@/types/Schedule";

const fetchSchedule: (id: number | null) => Promise<Schedule> = async (id: number | null) => {
    const response = await axios.get<ApiResponse>(`/api/schedules/${id}`, {
        headers: {"Cache-Control": "public, max-age=60"},
    });
    return response.data.data;
}

const deleteSchedule: (id: number | null) => Promise<AxiosResponse<ApiResponse> | undefined> = async (id: number | null) => {
    return await axios.delete(`/api/schedules/${id}`);
}

export default function ScheduleDisplay(
    {selectedScheduleId, updateTrigger}:
    Readonly<{
        selectedScheduleId: number | null;
        updateTrigger: (value: boolean) => void
    }>
) {
    const [selectedDateSchedule, setSelectedDateSchedule] = useState<Schedule | null>(null);

    useEffect(() => {
        (async () => {
            if (!selectedScheduleId) {
                setSelectedDateSchedule(null);
                return;
            }
            fetchSchedule(selectedScheduleId)
                .then((schedule) => {
                    setSelectedDateSchedule(schedule)
                })
                .catch((error) => {
                    console.error(error);
                })
        })();
    }, [selectedScheduleId])

    const handleDeleteClick = async (id: number | null) => {
        deleteSchedule(id)
            .then((response) => {
                if (response?.status === 204) {
                    updateTrigger(true);
                    setSelectedDateSchedule(null);
                }
            })
            .catch((error) => {
                console.error(error)
            })
    }

    return (
        <div className="w-1/2 p-5 mx-auto">
            <div className="mb-5">
                {selectedDateSchedule ?
                    <div
                        key={selectedDateSchedule.id}
                        className="border border-gray-300 rounded-md p-4 mb-4 shadow-sm"
                    >
                        <p>
                            <strong>날짜:</strong> {selectedDateSchedule.date}
                        </p>
                        <p>
                            <strong>이름:</strong> {selectedDateSchedule.name}
                        </p>
                        <p>
                            <strong>설명:</strong> {selectedDateSchedule.description}
                        </p>
                        <p>
                            <strong>시간:</strong> {selectedDateSchedule.startTime} ~ {selectedDateSchedule.endTime}
                        </p>
                        <div className="mt-4 flex space-x-2">
                            <button
                                type="button"
                                className="p-2 bg-blue-500 text-white rounded-md hover:bg-blue-600"
                            >
                                편집
                            </button>
                            <button
                                type="button"
                                className="p-2 bg-red-500 text-white rounded-md hover:bg-red-600"
                                onClick={() => handleDeleteClick(selectedDateSchedule.id)}
                            >
                                삭제
                            </button>
                        </div>
                    </div>
                    : <p className="text-center text-gray-500">등록된 일정이 없습니다.</p>
                }
            </div>
            <ScheduleEditor selectedDateSchedule={selectedDateSchedule} updateTriggerAction={updateTrigger}/>
        </div>
    );
}