import React from "react";
import "./NavigationBar.module.css";

function NavigationBar({role = "none"}) {
    return (
        <nav>
            {role === "none" && (
                <div>

                </div>
            )}
            {role === "student" && (
                <ul>
                    <li>ExSys</li>
                    <li>About</li>
                    <li>Profile</li>
                </ul>
            )}
            {role === "teacher" && (
                <ul>
                    <li>ExSys</li>
                    <li>About</li>
                    <li>Past Exams</li>
                    <li>Logout</li>
                </ul>
            )}
        </nav>
    );
}

export default NavigationBar;
