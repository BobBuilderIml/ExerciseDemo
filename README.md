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
