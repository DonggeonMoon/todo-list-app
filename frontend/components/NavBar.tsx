import Link from "next/link";

export default function NavBar() {
    return (
        <header className="flex justify-center text-center">
            <ul className="flex">
                <li className="p-2"><Link href="/">Home</Link></li>
                <li className="p-2"><Link href="/about">About</Link></li>
                <li className="p-2"><Link href="/calendar">Calendar</Link></li>
                <li className="p-2"><Link href="/login">Sign In</Link></li>
            </ul>
        </header>
    )
}