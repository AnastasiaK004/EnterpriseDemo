import React, { useState, useEffect } from "react";
import { getEntityById, updateEntity, getEntities } from "../../services/api";
import { useParams } from "react-router-dom";
import {
    Button,
    Container,
    TextField,
    Typography,
    Box,
    Select,
    MenuItem,
    FormControl,
    InputLabel
} from "@mui/material";

export default function EmployeeDetails() {
    const { id } = useParams(); // Получение ID из URL
    const [salary, setSalary] = useState("");
    const [fullName, setFullname] = useState("");
    const [departmentId, setDepartmentId] = useState("");
    const [department, setDepartment] = useState([]);

    useEffect(() => {
        getEntityById("employee", id).then((response) => {
            const { fullName, salary, departmentId } = response.data;
            setFullname(fullName);
            setSalary(salary);
            setDepartmentId(departmentId);
            getEntities("department/"+departmentId).then((response) => {
                setDepartment(response.data);
            });
        });

    }, [id, departmentId]);

    const handleSubmit = (e) => {
        e.preventDefault();
        updateEntity("employee", id, { fullName, salary, departmentId }).then(() => {
            window.location.href = `/departments/${department.id}/employees`;
        });
    };

    return (
        <Container>
            <Typography variant="h4" gutterBottom>
                Изменить данные о сотруднике
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
                    label="ФИО сотрудника"
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
                <TextField
                    label=""
                    variant="outlined"
                    value={"Подразделение: "+department.name}
                    readOnly
                />
                <Button type="submit" variant="contained" color="primary">
                    Сохранить изменения
                </Button>
            </Box>
        </Container>
    );
}
