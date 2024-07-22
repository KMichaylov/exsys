import {Grid, MantineProvider, Stack, Table, Text, Title} from "@mantine/core";
import NavigationBar from "../../../components/NavigationBar/NavigationBar.jsx";
import HeadingText from "../../../components/HeadingText/HeadingText.jsx";
import React from "react";
import getCssVariableValue from "../../../utils/getcsscolor.js";
import SearchInput from "../../../components/SearchInput/SearchInput.jsx";
import CustomButton from "../../../components/CustomButton/CustomButton.jsx";
import "./StatisticsPage.css"
import KPI from "../../../components/KPI/KPI.jsx";

function StatisticsPage() {
    const primaryButtonColor = getCssVariableValue("--primary-button-color");
    const primaryColor = getCssVariableValue("--primary-color");
    const boxColor = getCssVariableValue("--box-color");
    const secondaryButtonColor = getCssVariableValue("--secondary-button-color")

    return (
        <MantineProvider>
            <NavigationBar role={"teacher"}/>
            <div className="wrapper-home-page">
                <NavigationBar role={"student"}/>
                <div className="text-header-wrapper">
                    <HeadingText color={"black"} text={"Exam Statistics"} size={"h2"}/>
                    <SearchInput label={"Exam Name"}/>
                </div>
                <div className={"statistics-body-wrapper"}>
                    <Grid gutter="md">
                        <Grid.Col span={6} style={{paddingRight: '5.5rem'}}>
                            <Stack align="stretch">
                                <Title>Test Summary</Title>
                                <KPI textTitle={"Total points: 50 points"} textSize={"h6"}/>
                                <KPI textTitle={"Total time: 1 hour"} textSize={"h6"}/>
                                <KPI textTitle={"Average: 36.33 points"} textSize={"h6"}/>
                                <KPI textTitle={"Median: 32"} textSize={"h6"}/>
                                <KPI textTitle={"Standard Deviation: 6.664"} textSize={"h6"}/>
                                <KPI textTitle={"Percentage of Passing Students: 65%"} textSize={"h6"}/>
                                <KPI textTitle={"Average time to complete: 40:45 minutes"} textSize={"h6"}/>
                            </Stack>
                        </Grid.Col>
                        <Grid.Col span={6} style={{paddingLeft: '5.5rem'}}>
                            <Stack align="stretch" justify="center" gap="md">
                                <Title>Distribution</Title>

                            </Stack>
                        </Grid.Col>
                    </Grid>
                    <div className={"button-group"}>
                        <CustomButton isFullWidth={false} buttonText={"Back"} color={secondaryButtonColor}/>
                    </div>

                </div>
            </div>
        </MantineProvider>
    );
}

export default StatisticsPage