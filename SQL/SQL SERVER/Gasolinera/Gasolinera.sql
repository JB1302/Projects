--CREAR DB
CREATE DATABASE Gasolinera;
GO;

--Usar DB
USE Gasolinera;
GO

--empleados
CREATE TABLE empleados(
id_empleado INT PRIMARY KEY,
nombre VARCHAR(10),
turno VARCHAR(10),
fecha_ingreso DATE
);
GO


--empleados
CREATE TABLE combustible(
id_combustible INT PRIMARY KEY,
tipo VARCHAR(8),
precio_por_litro DECIMAL(8,2),
stock_actual DECIMAL(10,2)
);
GO

--Gestionar Ventas
CREATE TABLE ventas(
id_venta INT PRIMARY KEY,
id_empleado INT FOREIGN KEY(id_empleado) REFERENCES empleados(id_empleado),
id_combustible INT FOREIGN KEY(id_combustible) REFERENCES combustible(id_combustible),
litros_vendidos DECIMAL(10,2),
TOTAL DECIMAL(10,2),
fecha_venta DATETIME
);
GO

CREATE TABLE auditoria(
id_auditoria INT PRIMARY KEY IDENTITY(1,1),
id_venta INT FOREIGN KEY(id_venta) REFERENCES ventas(id_venta),
acción VARCHAR(50),
Fecha DATETIME DEFAULT GETDATE()
);
GO

INSERT INTO empleados (id_empleado, nombre, turno, fecha_ingreso) VALUES
(1, 'Carlos', 'mañana', '2022-01-10'),
(2, 'Laura', 'tarde', '2023-05-15'),
(3, 'Jorge', 'noche', '2021-09-01'),
(4, 'Ana', 'mañana', '2022-11-20'),
(5, 'Luis', 'tarde', '2023-07-05');
GO

INSERT INTO combustible (id_combustible, tipo, precio_por_litro, stock_actual) VALUES
(1, 'Super', 815.50, 1200.75),
(2, 'Regular', 765.30, 900.00),
(3, 'Diesel', 689.25, 1500.00),
(4, 'GLP', 420.00, 300.50),
(5, 'Etanol', 590.75, 800.80);
GO

INSERT INTO ventas (id_venta, id_empleado, id_combustible, litros_vendidos, TOTAL, fecha_venta) VALUES
(1, 1, 1, 20.00, 16310.00, '2025-07-25 08:15:00'),
(2, 2, 2, 15.50, 11861.15, '2025-07-25 14:40:00'),
(3, 3, 3, 30.00, 20677.50, '2025-07-26 22:10:00'),
(4, 4, 4, 10.00, 4200.00, '2025-07-27 09:05:00'),
(5, 5, 5, 12.00, 7089.00, '2025-07-27 16:30:00');
GO

INSERT INTO auditoria (id_venta, acción) VALUES
(1, 'Inserción de venta'),
(2, 'Inserción de venta'),
(3, 'Inserción de venta'),
(4, 'Inserción de venta'),
(5, 'Inserción de venta');
GO


--Trigger (insert) de Venta
CREATE TRIGGER tab_ventas_insert
ON ventas
AFTER INSERT

AS
BEGIN
INSERT INTO auditoria(
	id_venta,acción,Fecha
)
SELECT
	i.id_venta,
	'Inserción de venta',
	GETDATE()
FROM inserted i
END
GO


INSERT INTO ventas (id_venta, id_empleado, id_combustible, litros_vendidos, TOTAL, fecha_venta) VALUES
(7, 5, 5, 13.00, 7089.00, '2025-07-27 17:45:00');
GO

--Trigger (Update) de Venta
CREATE TRIGGER tab_ventas_Update
ON ventas
AFTER UPDATE

AS
BEGIN
INSERT INTO auditoria(
	id_venta,acción,Fecha
)
SELECT
	i.id_venta,
	'SE MODIFICO UNA VENTA',
	GETDATE()
FROM inserted i
END
GO


UPDATE ventas
SET litros_vendidos = 14.00
where id_venta = 7

--Vista con stock bajo (<1000)
CREATE VIEW stock_bajo AS
	SELECT *
	FROM combustible
	WHERE stock_actual < 1000
GO

--Vista con stock alto (>=1000)
CREATE VIEW stock_alto AS
	SELECT *
	FROM combustible
	WHERE stock_actual >= 1000
GO


--Funcíón de Stock
CREATE FUNCTION f_estado_stock(
	@stock_actual INT
)
RETURNS VARCHAR(20)
AS
BEGIN
	DECLARE @estado VARCHAR(20);

	SET @estado = CASE
					WHEN @stock_actual = 0 THEN 'Agotado'
					WHEN @stock_actual < 100 THEN 'Bajo'
					ELSE 'Suficiente'
				END;
			RETURN @estado;
		END;
		GO

--Probar Función
SELECT 
    tipo, 
    stock_actual, 
    dbo.f_estado_stock(stock_actual) AS estado_stock
FROM combustible;
GO




--Registrar Venta
CREATE PROCEDURE RegistrarVenta
    @ID_VENTA INT,
    @ID_EMPLEADO INT,
    @ID_COMBUSTIBLE INT,
    @LITROS_VENDIDOS DECIMAL(10,2),
    @TOTAL DECIMAL(10,2),
    @FECHA_VENTA DATETIME
AS
BEGIN
    INSERT INTO ventas (
        id_venta, id_empleado, id_combustible, litros_vendidos, total, fecha_venta
    ) VALUES (
        @ID_VENTA, @ID_EMPLEADO, @ID_COMBUSTIBLE, @LITROS_VENDIDOS, @TOTAL, @FECHA_VENTA
    );
END;
GO

-- EJECUTAR PROCEDIMIENTO
EXEC RegistrarVenta 8, 2, 1, 25.5, 20795.25, '2025-07-28 12:00:00';
GO



--Stock < 100
CREATE PROCEDURE MostrarStockBajo
AS
BEGIN
    SELECT * 
    FROM combustible
    WHERE stock_actual < 1000;
END;
GO

-- EJECUTAR PROCEDIMIENTO
EXEC MostrarStockBajo;
GO



--Mostrar fechas en un rango
CREATE PROCEDURE MostrarVentasPorFecha
    @FECHA_INICIO DATETIME,
    @FECHA_FIN DATETIME
AS
BEGIN
    SELECT *
    FROM ventas
    WHERE fecha_venta BETWEEN @FECHA_INICIO AND @FECHA_FIN;
END;
GO

-- EJECUTAR PROCEDIMIENTO
EXEC MostrarVentasPorFecha '2025-07-25', '2025-07-27';
GO
