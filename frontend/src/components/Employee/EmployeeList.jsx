import React, { useState, useEffect } from "react";
import { getEntities, deleteEntity, getEntityById } from "../../services/api";
import { useParams } from "react-router-dom";
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

export default function EmployeeList() {
    const [employees, setEmployees] = useState([]);
    const { departmentId } = useParams();
    const [department, setDepartment] = useState();
    const [isLoaded, setLoaded] = useState(false);

    useEffect(() => {
        getEntities("department/"+departmentId+"/employees").then((response) => {
            setEmployees(response.data);
        });

        getEntityById("department", departmentId).then((response) => {
            setDepartment(response.data);
            setLoaded(true)
        });
    }, []);

    const handleDelete = (id) => {
        deleteEntity("employee", id).then(() => {
            setEmployees(employees.filter((e) => e.id !== id));
        });
    };

    return (
        isLoaded?
        <Container>
            <Typography variant="h4" gutterBottom>
                Сотрудники, подраздение "{department.name}"
            </Typography>
            <Button
                variant="contained"
                color="primary"
                startIcon={<AddIcon />}
                onClick={() => (window.location.href = "/employees/"+departmentId+"/new")}
                style={{ marginBottom: "20px" }}
            >
                Добавить сотрудника
            </Button>
            <List>
                {employees.map((employee) => (
                    <ListItem key={employee.id} divider>
                        <ListItemText
                            primary={`${employee.fullName}`}
                            secondary={`Зарплата: ${employee.salary}`}
                        />
                        <ListItemSecondaryAction>
                            <IconButton
                                edge="end"
                                aria-label="view"
                                onClick={() => (window.location.href = `/employees/${employee.id}`)}
                            >
                                <VisibilityIcon />
                            </IconButton>
                            <IconButton
                                edge="end"
                                aria-label="delete"
                                onClick={() => handleDelete(employee.id)}
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
