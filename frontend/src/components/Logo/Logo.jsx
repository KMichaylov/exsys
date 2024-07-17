import React from "react";
import logoNoBackground from "../../assets/logo-no-background.svg";
import "./Logo.module.css"

function Logo() {
    return (
        <div className="logo-container">
            <img src={logoNoBackground} alt="Exam System Logo" />
        </div>
    );
}


export default Logo;