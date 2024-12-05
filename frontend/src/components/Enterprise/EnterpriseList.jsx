import React, { useState, useEffect } from "react";
import { getEntities, deleteEntity } from "../../services/api";
import {
    Button,
    Container,
    List,
    ListItem,
    ListItemText,
    ListItemSecondaryAction,
    Typography,
    IconButton
} from "@mui/material";
import DeleteIcon from "@mui/icons-material/Delete";
import AddIcon from "@mui/icons-material/Add";
import { useParams, useNavigate } from "react-router-dom";

export default function EnterpriseList() {
    const [enterprises, setEnterprises] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        getEntities("enterprise/all").then((response) => {
            setEnterprises(response.data);
        });
    }, []);

    const handleDelete = (id) => {
        deleteEntity("enterprise", id).then(() => {
            setEnterprises(enterprises.filter((e) => e.id !== id));
        });
    };

    return (
        <Container>
            <Typography variant="h4" gutterBottom>
                Предприятия
            </Typography>
            <Button
                variant="contained"
                color="primary"
                startIcon={<AddIcon />}
                onClick={() => (window.location.href = "/enterprises/new")}
                style={{ marginBottom: "20px" }}
            >
                Добавить предприятие
            </Button>
            <List>
                {enterprises.map((enterprise) => (
                    <ListItem 
                    key={enterprise.id} divider
                    onClick={() => navigate(`/enterprises/${enterprise.id}/departments`)}
                    >
                        <ListItemText primary={enterprise.name} />
                        <ListItemSecondaryAction>
                            <IconButton
                                edge="end"
                                aria-label="delete"
                                onClick={() => handleDelete(enterprise.id)}
                            >
                                <DeleteIcon />
                            </IconButton>
                        </ListItemSecondaryAction>
                    </ListItem>
                ))}
            </List>
        </Container>
    );
}
