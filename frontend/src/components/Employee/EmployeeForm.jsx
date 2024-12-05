import React, { useState, useEffect } from "react";
import { createEntity, getEntities } from "../../services/api";
import { useParams } from "react-router-dom";
import {
    Button,
    Container,
    TextField,
    Typography,
    Box,
    Select,
    MenuItem,
    InputLabel,
    FormControl
} from "@mui/material";

export default function EmployeeForm() {
    const [fullName, setFullname] = useState("");
    const [salary, setSalary] = useState("");
    const { departmentId } = useParams();

    const handleSubmit = (e) => {
        e.preventDefault();
        createEntity("employee", { fullName, salary, departmentId }).then(() => {
            window.location.href = "/departments/"+departmentId+"/employees";
        });
    };

    return (
        <Container>
            <Typography variant="h4" gutterBottom>
                New Employee
            </Typography>
            <Box
                component="form"
                onSubmit={handleSubmit}
                sx={{
                    display: "flex",
                    flexDirection: "column",
                    gap: 2,
                    maxWidth: "400px",
                    margin: "0 auto"
                }}
            >
                <TextField
                    label="ФИО работника"
                    variant="outlined"
                    value={fullName}
                    onChange={(e) => setFullname(e.target.value)}
                    required
                />
                <TextField
                    label="Зарплата"
                    variant="outlined"
                    value={salary}
                    onChange={(e) => setSalary(e.target.value)}
                    required
                />
                <Button type="submit" variant="contained" color="primary">
                    Save
                </Button>
            </Box>
        </Container>
    );
}
