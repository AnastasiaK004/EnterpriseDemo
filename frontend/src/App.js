import React from "react";
import { BrowserRouter as Router, Route, Routes, Link } from "react-router-dom";
import EnterpriseList from "./components/Enterprise/EnterpriseList";
import EnterpriseForm from "./components/Enterprise/EnterpriseForm";
import DepartmentList from "./components/Department/DepartmentList";
import DepartmentForm from "./components/Department/DepartmentForm";
import EmployeeList from "./components/Employee/EmployeeList";
import EmployeeForm from "./components/Employee/EmployeeForm";
import DepartmentDetails from "./components/Department/DepartmentDetails";
import EmployeeDetails from "./components/Employee/EmployeeDetails";

import { AppBar, Toolbar, Typography, Container, Button } from "@mui/material";

function App() {
  return (
      <Router>
        <AppBar position="static">
          <Toolbar>
            <Typography variant="h6" sx={{ flexGrow: 1 }}>
              EnterpriseDemo
            </Typography>
            <Button color="inherit" component={Link} to="/enterprises">
              Предприятия
            </Button>
          </Toolbar>
        </AppBar>
        <Container sx={{ marginTop: "20px" }}>
          <Routes>
            <Route path="/enterprises" element={<EnterpriseList />} />
            <Route path="/enterprises/new" element={<EnterpriseForm />} />
            <Route path="/enterprises/:enterpriseId/departments" element={<DepartmentList />} />

            <Route path="/departments/:departmentId/employees" element={<EmployeeList />} />
            <Route path="/departments/:enterpriseId/new" element={<DepartmentForm />} />
            <Route path="/departments/:enterpriseId/:id" element={<DepartmentDetails />} />

            <Route path="/employees" element={<EmployeeList />} />
            <Route path="/employees/:departmentId/new" element={<EmployeeForm />} />
            <Route path="/employees/:id" element={<EmployeeDetails />} />
          </Routes>
        </Container>
      </Router>
  );
}

export default App;
