--Para quitar cualquier selección de DB
USE master;
GO

--Borrar la tabla si ya existe
IF EXISTS (SELECT name FROM sys.databases WHERE name = 'db_tarea_04')
BEGIN
    ALTER DATABASE db_tarea_04 SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE db_tarea_04;
END
GO

--Crear base de datos
CREATE DATABASE db_tarea_04;
GO

--USar DB
USE db_tarea_04;
GO

--Crear Tabla
CREATE TABLE
  tab_empleados (
    --PK AUTO
    ID INT NOT NULL PRIMARY KEY,
    NOMBRE VARCHAR(20) NOT NULL,
    APELLIDO_1 VARCHAR(20) NOT NULL,
    APELLIDO_2 VARCHAR(20) NOT NULL,
    RESIDENCIA VARCHAR(20) NOT NULL,
    PUESTO VARCHAR(20) NOT NULL,
    SALARIO NUMERIC(18, 2),
    FECHA_ALTA DATE NOT NULL,
    FECHA_BAJA DATE
  );

  GO
  
  --INSERT EN LA TABLA
INSERT INTO tab_empleados (
    ID,
    NOMBRE,
    APELLIDO_1,
    APELLIDO_2,
    RESIDENCIA,
    PUESTO,
    SALARIO,
    FECHA_ALTA,
    FECHA_BAJA
) VALUES
      (102560963, 'JUAN', 'PREZ', 'BERMUDEZ', 'HEREDIA', 'TI', 800000, '2000-01-01', NULL),
      (205890632, 'CARLOS', 'CASTRO', 'NOGUERA', 'SAN JOSE', 'CONTABILIDAD', 800000, '2001-05-01', '2020-06-01'),
      (485691235, 'ADRIAN', 'ZELEDON', 'ALPIZAR', 'ALAJUELA', 'CONTABILIDAD', 800000, '2001-05-01', NULL),
      (178962356, 'FABIO', 'ALPIZAR', 'ALPIZAR', 'CARTAGO', 'TESORERIA', 1000000, '2010-08-10', NULL),
      (178549652, 'JULIA', 'BOGANTES', 'ZELEDON', 'HEREDIA', 'MANTENIMIENTO', 350000, '2015-02-15', '2022-10-10'),
      (256358569, 'MIA', 'BOJORGE', 'CHACON', 'SAN JOSE', 'TI', 1100000, '2021-11-02', NULL),
      (352638569, 'PEDRO', 'RAMIREZ', 'DIZA', 'ALAJUELA', 'TESORERIA', 1100000, '2023-03-28', NULL),
      (523652365, 'LUCAS', 'CHAVEZ', 'ESPINOZA', 'CARTAGO', 'MANTENIMIENTO', 650000, '2021-03-20', '2023-03-20'),
      (513649865, 'GERARDO', 'NOGUERA', 'BARBOZA', 'SAN JOSE', 'TI', 1200000, '2019-07-19', '2022-12-15');
  GO

  --Crear Stored Procedure (Almacenar Valor)
  CREATE PROCEDURE InsertarEmpleado
        @ID INT,
        @NOMBRE VARCHAR(20),
        @APELLIDO_1 VARCHAR(20),
        @APELLIDO_2 VARCHAR(20),
        @RESIDENCIA VARCHAR(20),
        @PUESTO VARCHAR(20),
        @SALARIO NUMERIC(18, 2),
        @FECHA_ALTA DATE,
        @FECHA_BAJA DATE = NULL
    AS 
    BEGIN
        INSERT INTO tab_empleados(
            ID,NOMBRE,APELLIDO_1,APELLIDO_2,RESIDENCIA,PUESTO,SALARIO,FECHA_ALTA,FECHA_BAJA
        )VALUES(
            @ID,@NOMBRE,@APELLIDO_1,@APELLIDO_2,@RESIDENCIA,@PUESTO,@SALARIO,@FECHA_ALTA,@FECHA_BAJA
        );
    END
    GO

    --EJECUTAR STORED PROCEDURE
    EXEC InsertarEmpleado 
    987654351, 'MARIO', 'LOPEZ', 'GARCIA', 'HEREDIA', 'CONTABILIDAD', 900000, '2023-05-10', NULL;
    GO


      --Crear Stored Procedure (Select no dado de baja)
  CREATE PROCEDURE EmpleadosActivo
  AS
  BEGIN
        SELECT 
            [ID],[NOMBRE],[APELLIDO_1],[RESIDENCIA],[PUESTO],[SALARIO]
        FROM
            [db_tarea_04].[dbo].[tab_empleados]
        WHERE
            FECHA_BAJA IS NULL;
    END
    GO

    --EJECUTAR STORED PROCEDURE
    EXEC  EmpleadosActivo
    GO



 --Crear Stored Procedure (Update Dado de baja)
  CREATE PROCEDURE ActualizarFechaBaja
      @ID INT,
      @fecha_baja DATE

  AS
  BEGIN
        UPDATE  tab_empleados
        SET FECHA_BAJA = @FECHA_BAJA
        WHERE ID = @ID;
    END
    GO

    --EJECUTAR STORED PROCEDURE
    EXEC  ActualizarFechaBaja 485691235,'2024-12-01'
    GO


    --trigger
    
    --TABLA DE AUDITORIA
    CREATE TABLE auditoria_tab_empleados (
    ID_AUDITORIA INT IDENTITY(1,1) PRIMARY KEY,
    ID_EMPLEADO INT,
    ACCION VARCHAR(10),
    USUARIO_SQL NVARCHAR(128),
    FECHA_AUDITORIA DATETIME,
    DATOS_ANTERIORES NVARCHAR(MAX),
    DATOS_NUEVOS NVARCHAR(MAX)
);
    
    GO

    --PROCESO TRIGGER
    CREATE TRIGGER tab_empleados_update
    ON tab_empleados
    AFTER UPDATE
    
    AS
    BEGIN
    INSERT INTO auditoria_tab_empleados (
        ID_EMPLEADO, ACCION, USUARIO_SQL, FECHA_AUDITORIA, DATOS_ANTERIORES, DATOS_NUEVOS
    )
    SELECT 
        i.ID, 
        'UPDATE',
        SYSTEM_USER,
        GETDATE(),
        CONCAT('ANTES: ', d.NOMBRE, ', ', d.APELLIDO_1, ', ', d.PUESTO, ', ', d.SALARIO, ', ', d.FECHA_BAJA),
        CONCAT('DESPUES: ', i.NOMBRE, ', ', i.APELLIDO_1, ', ', i.PUESTO, ', ', i.SALARIO, ', ', i.FECHA_BAJA)
    FROM inserted i
    INNER JOIN deleted d ON i.ID = d.ID;
END
GO


    --EJECUTAR STORED PROCEDURE (Verificar Trigger)
    EXEC  ActualizarFechaBaja 485691235,'2024-12-02'
    GO


    --Crear View
    CREATE VIEW salarios_mayor_millon AS
    SELECT *
    FROM tab_empleados
    WHERE SALARIO > 1000000
    GO

    --Ejecutar Vista
    SELECT * FROM salarios_mayor_millon;
    GO


