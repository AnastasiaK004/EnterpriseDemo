import React, { useState } from "react";
import { createEntity } from "../../services/api";
import {
    Button,
    Container,
    TextField,
    Typography,
    Box
} from "@mui/material";

export default function EnterpriseForm() {
    const [name, setName] = useState("");
    const [description, setDescription] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        createEntity("enterprise", { name, description }).then(() => {
            window.location.href = "/enterprises";
        });
    };

    return (
        <Container>
            <Typography variant="h4" gutterBottom>
                New Enterprise
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
                    label="Enterprise Name"
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
                    Save
                </Button>
            </Box>
        </Container>
    );
}
