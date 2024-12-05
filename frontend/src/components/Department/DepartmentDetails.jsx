import React, { useState, useEffect } from "react";
import { getEntityById, updateEntity } from "../../services/api";
import { useParams } from "react-router-dom";
import {
    Button,
    Container,
    TextField,
    Typography,
    Box
} from "@mui/material";

export default function DepartmentDetails() {
    const { id } = useParams(); // Получение ID из URL
    const [name, setName] = useState("");
    const { enterpriseId } = useParams();
    const [description, setDescription] = useState("");

    useEffect(() => {
        getEntityById("department", id).then((response) => {
            setName(response.data.name);
            setDescription(response.data.description)
        });
    }, [id]);

    const handleSubmit = (e) => {
        e.preventDefault();
        updateEntity("department", id, { name, description, enterpriseId }).then(() => {
            window.location.href = `/enterprises/${enterpriseId}/departments`;
        });
    };

    return (
        <Container>
            <Typography variant="h4" gutterBottom>
                Изменить подраздение
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
                    label="Название подразделения"
                    variant="outlined"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    required
                />
                <TextField
                    label="Описание"
                    variant="outlined"
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
                    required
                />
                <Button type="submit" variant="contained" color="primary">
                    Сохранить изменения
                </Button>
            </Box>
        </Container>
    );
}
