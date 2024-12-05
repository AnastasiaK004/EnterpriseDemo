import React, { useState, useEffect } from "react";
import { getEntities, deleteEntity } from "../../services/api";
import { useParams, useNavigate } from "react-router-dom";
import AddIcon from "@mui/icons-material/Add";
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
import VisibilityIcon from "@mui/icons-material/Visibility";

export default function DepartmentList() {
    const [departments, setDepartments] = useState([]);
    const { enterpriseId } = useParams();
    const [isLoaded, setLoaded] = useState(false);
    const navigate = useNavigate();

    useEffect(() => {
        getEntities("enterprise/"+enterpriseId+"/departments").then((response) => {
            setDepartments(response.data);
            setLoaded(true)
        });
    }, []);

    const handleDelete = (id) => {
        deleteEntity("department", id).then(() => {
            setDepartments(departments.filter((d) => d.id !== id));
        });
    };

    return (
        isLoaded?
        <Container>
            <Typography variant="h4" gutterBottom>
                Подразделения
            </Typography>
            <Button
                variant="contained"
                color="primary"
                startIcon={<AddIcon />}
                onClick={() => (window.location.href = "/departments/"+enterpriseId+"/new")}
                style={{ marginBottom: "20px" }}
            >
                Добавить подразделение
            </Button>
            <List>
                {departments.map((department) => (
                    <ListItem key={department.id} divider
                    onClick={() => navigate(`/departments/${department.id}/employees`)}>
                        <ListItemText primary={department.name} />
                        <ListItemSecondaryAction>
                            <IconButton
                                edge="end"
                                aria-label="view"
                                onClick={() => (window.location.href = `/departments/${enterpriseId}/${department.id}`)}
                            >
                                <VisibilityIcon />
                            </IconButton>
                            <IconButton
                                edge="end"
                                aria-label="delete"
                                onClick={() => handleDelete(department.id)}
                            >
                                <DeleteIcon />
                            </IconButton>
                        </ListItemSecondaryAction>
                    </ListItem>
                ))}
            </List>
        </Container>:null
    );
}
