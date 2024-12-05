import React, { useState } from "react";
import { createEntity } from "../../services/api";
import { useParams, useNavigate } from "react-router-dom";
import {
    Button,
    Container,
    TextField,
    Typography,
    Box
} from "@mui/material";

export default function DepartmentForm() {
    const [name, setName] = useState("");
    const [description, setDescription] = useState("");
    const { enterpriseId } = useParams();

    const handleSubmit = (e) => {
        e.preventDefault();
        createEntity("department", { name, description, enterpriseId}).then(() => {
            window.location.href = "/enterprises/"+enterpriseId+"/departments";
        });
    };

    return (
        <Container>
            <Typography variant="h4" gutterBottom>
                New Department
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
                    label="Описание подразделения"
                    variant="outlined"
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
                    required
                />
                <Button type="submit" variant="contained" color="primary">
                    Save
                </Button>
            </Box>
        </Container>
    );
}
