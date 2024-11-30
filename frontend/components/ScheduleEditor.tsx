import React, {useEffect, useState} from "react";
import axios, {AxiosError, AxiosResponse} from "axios";
import {Schedule} from "@/types/Schedule";

axios.defaults.baseURL = "http://localhost:8080";

const createSchedule: (formData: Schedule) => Promise<AxiosResponse<ApiResponse>> = async (formData: Schedule) => {
    return await axios.post<ApiResponse>('/api/schedules', formData);
}

const modifySchedule: (formData: Schedule) => Promise<AxiosResponse<ApiResponse>> = async (formData: Schedule) => {
    return await axios.put<ApiResponse>(`/api/schedules`, formData);
}

export default function ScheduleEditor(
    {selectedDateSchedule, updateTriggerAction}
    : { selectedDateSchedule?: Schedule | null, updateTriggerAction: (value: boolean) => void }
) {
    let [formData, setFormData] = useState<Schedule>({
        id: null,
        name: "",
        description: "",
        date: "",
        startTime: "",
        endTime: "",
    });

    useEffect(() => {
        if (selectedDateSchedule) {
            setFormData(selectedDateSchedule);
            return;
        }
        setFormData({
            id: null,
            name: "",
            description: "",
            date: "",
            startTime: "",
            endTime: "",
        });
    }, [selectedDateSchedule]);

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const {name, value} = e.target;
        setFormData({
            ...formData,
            [name]: value
        })
    }

    const handleFormData = async (e: React.FormEvent) => {
        e.preventDefault()
        const createOrModifySchedule = (selectedDateSchedule === null)
            ? createSchedule(formData)
            : modifySchedule(formData);

        createOrModifySchedule.then((response) => {
            if (response.data.header.code === 201 || response.data.header.code === 204) {
                updateTriggerAction(true);
                setFormData({
                    id: null,
                    name: "",
                    description: "",
                    date: "",
                    startTime: "",
                    endTime: "",
                });
                return;
            }
            alert(response.data.header.message);
        }).catch((error: AxiosError<ApiResponse>) => {
            alert(error?.response?.data?.header.message)
        })
    }

    return (
        <div className="border border-gray-300 rounded-md p-6 shadow-sm">
            <h2 className="text-center text-lg font-bold mb-4">{selectedDateSchedule ? '일정 수정' : '새 일정 등록'}</h2>
            <form onSubmit={handleFormData}>
                <div className="mb-4">
                    <label htmlFor="date" className="block font-bold mb-2">
                        날짜:
                    </label>
                    <input
                        type="date"
                        id="date"
                        name="date"
                        value={formData.date}
                        className="w-full border border-gray-300 rounded-md p-2"
                        onChange={handleChange}
                    />
                </div>

                <div className="mb-4">
                    <label htmlFor="startTime" className="font-bold mb-2">
                        시작 시간:
                    </label>
                    <input
                        type="time"
                        id="startTime"
                        name="startTime"
                        value={formData.startTime}
                        className="border border-gray-300 rounded-md p-2 w-full"
                        onChange={handleChange}
                    />
                </div>
                <div className="mb-4">
                    <label htmlFor="endTime" className="font-bold mb-2">
                        종료 시간:
                    </label>
                    <input
                        type="time"
                        id="endTime"
                        name="endTime"
                        value={formData.endTime}
                        className="border border-gray-300 rounded-md p-2 w-full"
                        onChange={handleChange}
                    />
                </div>

                <div className="mb-4">
                    <label htmlFor="name" className="block font-bold mb-2">
                        이름:
                    </label>
                    <input
                        type="text"
                        id="name"
                        name="name"
                        value={formData.name}
                        placeholder="이름"
                        className="w-full border border-gray-300 rounded-md p-2"
                        onChange={handleChange}
                    />
                </div>

                <div className="mb-4">
                    <label htmlFor="description" className="block font-bold mb-2">
                        설명:
                    </label>
                    <input
                        type="text"
                        id="description"
                        name="description"
                        value={formData.description}
                        placeholder="설명"
                        className="w-full border border-gray-300 rounded-md p-2"
                        onChange={handleChange}
                    />
                </div>

                <button
                    type="submit"
                    className="w-full bg-blue-500 text-white font-bold py-2 rounded-md hover:bg-blue-600"
                >
                    {selectedDateSchedule ? "일정 수정" : "일정 등록"}
                </button>
            </form>
        </div>
    );
}