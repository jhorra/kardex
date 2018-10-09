# kardex
Prueba tecnica kardex

1.- Base de datos

CREATE BIGFILE TABLESPACE KARDEX_TS
  DATAFILE 'ORACLE_HOME\XE\KARDEX.DBF'
    SIZE 1048M
    AUTOEXTEND ON;
    
CREATE USER kardex
      IDENTIFIED BY kardex
      DEFAULT TABLESPACE  KARDEX_TS
      QUOTA 100M ON KARDEX_TS;
grant dba to SAPDA1;

Ejecutar script que se encuentra en: /git_kardex/kardex-bdd (este crea el modelo y crea datos iniciales)

2.- En el Jboss configurar el recurso JNDI con el nombre: java:jboss/datasources/kardexDS, con las credenciales del usuario y la base de datos creadas con el punto anterior)

3.- Compilar el proyecto con el siguiente comando: mvn clean install -Dhttps.protocols=TLSv1.2

4. Ruta para acceso a la aplicacion: localhost:8083/kardex-web/

5.- Pruebas unitarias, el JBOSS debe estar corriendo para poder ejecutar el preuba unitaria de la clase: /git_kardex/kardex-ejb/src/test/java/com/kardex/test/ProductoTest.java
