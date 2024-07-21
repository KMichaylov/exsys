import {MantineProvider, Table} from "@mantine/core";
import NavigationBar from "../../../components/NavigationBar/NavigationBar.jsx";
import HeadingText from "../../../components/HeadingText/HeadingText.jsx";
import React from "react";
import "./ExamGradingPage.css"
import getCssVariableValue from "../../../utils/getcsscolor.js";
import KPI from "../../../components/KPI/KPI.jsx";
import SearchInput from "../../../components/SearchInput/SearchInput.jsx";
import CustomButton from "../../../components/CustomButton/CustomButton.jsx";

function ExamGradingPage() {

    const primaryButtonColor = getCssVariableValue("--primary-button-color");
    const secondaryButtonColor = getCssVariableValue("--secondary-button-color")
    const primaryColor = getCssVariableValue("--primary-color");
    const boxColor = getCssVariableValue("--box-color");

    return (<MantineProvider>
            <NavigationBar role={"teacher"}/>
            <div className="wrapper-page">
                <div className="text-header-wrapper">
                    <HeadingText color={"black"} text={"Exam - Calculus A"} size={"h2"}/>
                    <div className={"kpi-blocks"}>
                        <KPI number={3} numberSize={"h1"} textSize={"h5"} textTitle={"Submitted Exams"}/>
                        <KPI number={2} numberSize={"h1"} textSize={"h5"} textTitle={"Graded Exams"}/>
                        <KPI number={6.5} numberSize={"h1"} textSize={"h5"} textTitle={"Average Grade"}/>
                    </div>
                </div>
                <div className={"table-body-wrapper"}>
                    <SearchInput label={"Search for student"}/>
                    <Table.ScrollContainer minWidth={500}>
                        <Table>
                            <Table.Thead>
                                <Table.Tr>
                                    <Table.Th>Full Name</Table.Th>
                                    <Table.Th>Student Number</Table.Th>
                                    <Table.Th>Status</Table.Th>
                                    <Table.Th>Grade</Table.Th>
                                </Table.Tr>
                            </Table.Thead>
                            <Table.Tbody></Table.Tbody>
                        </Table>
                    </Table.ScrollContainer>
                    <div className={"button-group"}>
                        <CustomButton isFullWidth={false} buttonText={"Back"} color={secondaryButtonColor}/>
                        <CustomButton isFullWidth={false} buttonText={"Save"} color={primaryButtonColor}/>
                    </div>
                </div>
            </div>
        </MantineProvider>
    );


}

export default ExamGradingPage