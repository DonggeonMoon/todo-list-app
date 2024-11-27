"use client"
import FullCalendar from "@fullcalendar/react";
import dayGridPlugin from '@fullcalendar/daygrid'

type Schedule = {
    id: number;
    name: string;
    description: string;
    date: string;
    startTime: string;
    endTime: string;
}

export const Calendar: React.FC<{ schedules: Schedule[] }> = ({schedules}: { schedules: Schedule[] }) => {
    schedules.forEach(i => {
        console.log({title: i.name, date: i.date})
    })
    return (
        <FullCalendar
            plugins={[dayGridPlugin]}
            initialView="dayGridMonth"
            locale="ko"
            events={schedules.map(i => ({title: i.name, date: i.date}))}
        />
    )
}
export default Calendar;