import {Group, MantineProvider} from "@mantine/core";
import CustomButton from "../../../components/CustomButton/CustomButton.jsx";
import {primaryButtonColor, secondaryButtonColor} from "../../../utils/colorsConstants.js";

function ExamPage() {

    return (
        <MantineProvider>
            <Group justify="space-between">
                <CustomButton isFullWidth={true} buttonText={"Previous"} color={secondaryButtonColor}/>
                <CustomButton isFullWidth={true} buttonText={"Next"} color={primaryButtonColor}/>
            </Group>
        </MantineProvider>);

}

export default ExamPage