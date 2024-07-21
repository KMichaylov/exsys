import {MantineProvider, Title} from "@mantine/core";
import "./KPI.css"

function KPI({textTitle, textSize, number, numberSize}) {
    return (<MantineProvider>
        <div id={"card-wrapper"}>
            <Title className={"kpi-text"} size={textSize}>{textTitle}</Title>
            <Title className={"kpi-text"} size={numberSize}>{number}</Title>
        </div>
    </MantineProvider>);
}

export default KPI