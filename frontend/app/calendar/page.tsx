import React from "react";
import axios from "axios";
import {Metadata} from "next";
import Calendar from "@/components/Calendar";
import NavBar from "@/components/NavBar";

export const metadata: Metadata = {
    title: "일정"
}

axios.defaults.baseURL = "http://localhost:8080";

type Schedule = {
    id: number;
    name: string;
    description: string;
    date: string;
    startTime: string;
    endTime: string;
}

const fetchSchedules = async () => {
    try {
        const response = await axios.get(`/api/schedules`);
        console.log(response.data.data.schedules)
        return response.data
            .data.schedules;
    } catch (error) {
        console.error(error);
        return [];
    }
};

export default async function Page() {
    const schedules = await fetchSchedules();

    return (
        <>
            <NavBar/>
            <div style={{display: "flex", justifyContent: "center"}}>
                <div style={{width: "50%", padding: "50px"}}>
                    <Calendar schedules={schedules}/>
                </div>
                <div style={{minWidth: "50%", padding: "50px", margin: "0 auto"}}>
                    <h1 style={{textAlign: "center"}}>일정 관리</h1>

                    {/* 일정 리스트 */}
                    <div style={{marginBottom: "20px"}}>
                        {schedules.length > 0 ? (
                            schedules.map((schedule: Schedule) => (
                                <div
                                    key={schedule.id}
                                    style={{
                                        border: "1px solid #ddd",
                                        borderRadius: "5px",
                                        padding: "10px",
                                        marginBottom: "10px",
                                    }}
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
                                </div>
                            ))
                        ) : (
                            <p style={{textAlign: "center"}}>등록된 일정이 없습니다.</p>
                        )}
                    </div>

                    {/* 일정 추가 폼 */}
                    <div
                        style={{
                            border: "1px solid #ddd",
                            borderRadius: "5px",
                            padding: "15px",
                        }}
                    >
                        <h2 style={{marginBottom: "10px"}}>새 일정 등록</h2>
                        <form>
                            <div style={{marginBottom: "10px"}}>
                                <label htmlFor="date" style={{display: "block", fontWeight: "bold"}}>
                                    날짜:
                                </label>
                                <input type="date" id="date" name="date" style={{width: "100%"}}/>
                            </div>

                            <div style={{marginBottom: "10px"}}>
                                <label htmlFor="startTime" style={{display: "block", fontWeight: "bold"}}>
                                    시작 시간:
                                </label>
                                <input type="time" id="startTime" name="startTime" style={{width: "100%"}}/>
                            </div>

                            <div style={{marginBottom: "10px"}}>
                                <label htmlFor="endTime" style={{display: "block", fontWeight: "bold"}}>
                                    종료 시간:
                                </label>
                                <input type="time" id="endTime" name="endTime" style={{width: "100%"}}/>
                            </div>

                            <div style={{marginBottom: "10px"}}>
                                <label htmlFor="name" style={{display: "block", fontWeight: "bold"}}>
                                    제목:
                                </label>
                                <input
                                    type="text"
                                    id="name"
                                    name="name"
                                    placeholder="제목"
                                    style={{width: "100%"}}
                                />
                            </div>

                            <div style={{marginBottom: "10px"}}>
                                <label htmlFor="description" style={{display: "block", fontWeight: "bold"}}>
                                    설명:
                                </label>
                                <input
                                    type="text"
                                    id="description"
                                    name="description"
                                    placeholder="설명"
                                    style={{width: "100%"}}
                                />
                            </div>

                            <button
                                type="submit"
                                style={{
                                    width: "100%",
                                    padding: "10px",
                                    backgroundColor: "#0070f3",
                                    color: "white",
                                    fontWeight: "bold",
                                    border: "none",
                                    borderRadius: "5px",
                                    cursor: "pointer",
                                }}
                            >
                                일정 등록
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </>
    );
}
Page;
