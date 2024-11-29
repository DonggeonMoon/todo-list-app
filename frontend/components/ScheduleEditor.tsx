'use client'
import React, {useState} from "react";
import axios from "axios";

axios.defaults.baseURL = "http://localhost:8080";

interface ScheduleEditorProps {

}

export default function ScheduleEditor({selectedDate}: { selectedDate?: string | null }) {
    let [formData, setFormData] = useState({
        id: null,
        name: "",
        description: "",
        date: "",
        startTime: "",
        endTime: "",
    });

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const {name, value} = e.target;
        setFormData({
            ...formData,
            [name]: value
        })
    }

    const handleFormData = async (e: React.FormEvent) => {
        e.preventDefault()
        try {
            const response = (selectedDate)
                ? await axios.post('/api/schedules', formData)
                : await axios.put(`/api/schedules/{formData.id}`, formData);

            if (response.data.header.code === 201) {
                alert('성공')
                return response.data.data;
            }
            alert('실패')
        } catch (error) {
            console.error(error);
            return [];
        }
    }

    return (
        <div className="border border-gray-300 rounded-md p-6 shadow-sm">
            <h2 className="text-center text-lg font-bold mb-4">{selectedDate ? '새 일정 등록' : '일정 수정'}</h2>
            <form onSubmit={handleFormData}>
                <div className="mb-4">
                    <label htmlFor="date" className="block font-bold mb-2">
                        날짜:
                    </label>
                    <input
                        type="date"
                        id="date"
                        name="date"
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
                        className="border border-gray-300 rounded-md p-2 w-full"
                        onChange={handleChange}
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
    );
}