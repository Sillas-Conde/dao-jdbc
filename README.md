Data Access Object - Java


Implementação de uma relação vendedo-departamento, com o objetivo de fixar os conhecimentos de acesso e modificação de Banco de dados usando conexões JDBC.

São implementados métodos para realizar as seguintes operações em banco de dados:

-Insert
-Update
-Delete By Id
-Find By Id
-Find All
-Find By Department (Apenas Objetos Seller)

O diagrama UML da relação vendedor-departamento segue abaixo:

![image](https://github.com/Sillas-Conde/dao-jdbc/assets/70293259/115ad950-5c03-4037-a06c-4e2ead78fb72)

Cada uma das relações entre Acesso a banco de dados tanto para Departamento quanto para Sellers é feita por meio de interfaces que são utilizadas pelas classes SellersDaoJDBC e DepartmentDaoJDBC, seguindo o modelo DaoFactory:

![image](https://github.com/Sillas-Conde/dao-jdbc/assets/70293259/ce36b9d1-90db-4460-a922-ada8d554942e)
