import React from "react";
import ScheduleEditor from "@/components/ScheduleEditor";

type Schedule = {
    id: number;
    name: string;
    description: string;
    date: string;
    startTime: string;
    endTime: string;
}

export default function ScheduleDisplay({schedules}: { schedules: Schedule[] }) {
    return (
        <>
            <div className="w-1/2 p-5 mx-auto">
                <div className="mb-5">
                    {schedules.length > 0 ? (
                            schedules.map((schedule: Schedule) => (
                                <div
                                    key={schedule.id}
                                    className="border border-gray-300 rounded-md p-4 mb-4 shadow-sm"
                                >
                                    <p>
                                        <strong>날짜:</strong> {schedule.date}
                                    </p>
                                    <p>
                                        <strong>이름:</strong> {schedule.name}
                                    </p>
                                    <p>
                                        <strong>설명:</strong> {schedule.description}
                                    </p>
                                    <p>
                                        <strong>시간:</strong> {schedule.startTime} ~ {schedule.endTime}
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
                                        >
                                            삭제
                                        </button>
                                    </div>
                                </div>
                            )))
                        : (
                            <p className="text-center text-gray-500">등록된 일정이 없습니다.</p>
                        )}
                </div>
                <ScheduleEditor/>
            </div>
        </>
    );
}