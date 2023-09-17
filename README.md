Task description : 
1. De creat un serviciu spring boot, cu controller, service, repository pentru resursele Department(name), Employee(name, email, salary), Projects(name) cu relațiile, un department poate aveam mai multi angajați, dar un angajat poate fi doar la un department. Un proiect poate fi la mai mulți angajati și un angajat poate fi in mai multe proiecte.

2. De ridicat baza de date local pe docker (mysql, postrgres, sau alta – la alegere) în care de salvat resursele de mai sus cu Hibernate ORM mapping

3. Cand se face request pe end-pointul department, sa intoarcă departamentul care sa conține un field averageSalary cu salariile medii ale angajaților acestui department.

How to start : 
1. First install Docker 
2. Obtain postgres images by running command : [ docker pull postgres ] additional links https://hub.docker.com/_/postgres
3. Run docker container with next command : [docker run --name demo-container -p 8282:5432 -e POSTGRES_USER=demoUser -e POSTGRES_PASSWORD=demoPassword -d postgres]

What was missed : 
1. No Unit tests
2. No Integration tests
3. No Exception Handler
4. No Logs
5. No Code optimization


Example of requests to employees : 
1. getAllEmployees GET http://localhost:8080/employees/all 
2. getEmployeeById GET http://localhost:8080/employees/1
3. addEmployee POST http://localhost:8080/employees/add 
`{
   "projectId" : 1,
   "name": "Harison Ford",
   "email" : "harisonFord@gmail.com",
   "salary" : 1800.00,
   "departmentId" : 1
   }`
Project id and department id are optional.
In case when employee has department , field departmentId is using for connectivity with departments.
In case when employee has project , field projectId is using for connectivity with projects.
4. updateEmployees PUT http://localhost:8080/employees/update 
`{ "id": 1
   "projectId" : 1,
   "name": "Harison Ford",
   "email" : "harisonFord@gmail.com",
   "salary" : 1800.00,
   "departmentId" : 1
   }`
5. deleteEmployee DELETE http://localhost:8080/employees/delete/1

Example of requests to projects :
1. getAllProjects GET http://localhost:8080/projects/all
2. getProjectById GET http://localhost:8080/projects/1
3. addProject POST http://localhost:8080/projects/add
   `{
   "projectName" : "CompanyOne"
   }`
4. updateProject PUT http://localhost:8080/projects/update
   `{ "id" : 1,"name" : "Human Resources"}`
5. deleteProject DELETE http://localhost:8080/projects/delete/1

Example of requests to departments :
1. getAllDepartments GET http://localhost:8080/departments/all
2. getDepartmentById GET http://localhost:8080/department/1
3. addDepartments POST http://localhost:8080/department/add
   `{
   "name" : "Developers"
   }`
4. updateDepartments PUT http://localhost:8080/department/update
   `{ "id" : 1,"name" : "Human Resources"}`
5. deleteDepartments DELETE http://localhost:8080/department/delete/1
