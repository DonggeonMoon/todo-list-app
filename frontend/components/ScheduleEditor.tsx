'use client'
import React, {useState} from "react";

export default function ScheduleEditor() {
    let [isCreateMode, setIsCreateMode] = useState(true);

    return (
        <>
            <div className="border border-gray-300 rounded-md p-6 shadow-sm">
                <h2 className="text-center text-lg font-bold mb-4">{isCreateMode ? '새 일정 등록' : '일정 수정'}</h2>
                <form>
                    <div className="mb-4">
                        <label htmlFor="date" className="block font-bold mb-2">
                            날짜:
                        </label>
                        <input
                            type="date"
                            id="date"
                            name="date"
                            className="w-full border border-gray-300 rounded-md p-2"
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
                            className="border border-gray-300 rounded-md p-2 w-full"
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
                            className="border border-gray-300 rounded-md p-2 w-full"
                        />
                    </div>

                    <div className="mb-4">
                        <label htmlFor="name" className="block font-bold mb-2">
                            제목:
                        </label>
                        <input
                            type="text"
                            id="name"
                            name="name"
                            placeholder="제목"
                            className="w-full border border-gray-300 rounded-md p-2"
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
                            placeholder="설명"
                            className="w-full border border-gray-300 rounded-md p-2"
                        />
                    </div>

                    <button
                        type="submit"
                        className="w-full bg-blue-500 text-white font-bold py-2 rounded-md hover:bg-blue-600"
                    >
                        일정 등록
                    </button>
                </form>
            </div>
        </>
    );
}