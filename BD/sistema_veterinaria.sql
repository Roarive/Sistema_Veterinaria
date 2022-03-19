-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.25 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para sistema_veterinaria
CREATE DATABASE IF NOT EXISTS `sistema_veterinaria` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sistema_veterinaria`;

-- Volcando estructura para tabla sistema_veterinaria.boleta
CREATE TABLE IF NOT EXISTS `boleta` (
  `idboleta` int NOT NULL AUTO_INCREMENT,
  `subtotal` double unsigned NOT NULL,
  `fecha` date NOT NULL,
  `igv` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `producto_idproducto` int NOT NULL,
  `empleados_idempleados` int NOT NULL,
  PRIMARY KEY (`idboleta`),
  KEY `fk_boleta_producto1_idx` (`producto_idproducto`),
  KEY `fk_boleta_empleados1_idx` (`empleados_idempleados`),
  CONSTRAINT `fk_boleta_empleados1` FOREIGN KEY (`empleados_idempleados`) REFERENCES `empleados` (`idempleados`),
  CONSTRAINT `fk_boleta_producto1` FOREIGN KEY (`producto_idproducto`) REFERENCES `producto` (`idproducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla sistema_veterinaria.boleta: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `boleta` DISABLE KEYS */;
/*!40000 ALTER TABLE `boleta` ENABLE KEYS */;

-- Volcando estructura para tabla sistema_veterinaria.cargo
CREATE TABLE IF NOT EXISTS `cargo` (
  `idcargo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idcargo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla sistema_veterinaria.cargo: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` (`idcargo`, `nombre`) VALUES
	(1, 'Administrador'),
	(2, 'Vendedor');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;

-- Volcando estructura para tabla sistema_veterinaria.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `dni` int NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla sistema_veterinaria.cliente: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Volcando estructura para tabla sistema_veterinaria.detalle_boleta
CREATE TABLE IF NOT EXISTS `detalle_boleta` (
  `iddetalle_boleta` int NOT NULL AUTO_INCREMENT,
  `servicio` varchar(45) NOT NULL,
  `cantidad` int NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`iddetalle_boleta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla sistema_veterinaria.detalle_boleta: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `detalle_boleta` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_boleta` ENABLE KEYS */;

-- Volcando estructura para tabla sistema_veterinaria.detalle_factura
CREATE TABLE IF NOT EXISTS `detalle_factura` (
  `iddetalle_factura` int NOT NULL,
  `cantidad` int NOT NULL,
  `preciounitario` double NOT NULL,
  `subtotal` double NOT NULL,
  `factura_idfactura` int NOT NULL,
  `producto_idproducto` int NOT NULL,
  PRIMARY KEY (`iddetalle_factura`,`producto_idproducto`),
  KEY `fk_detalle_factura_factura1_idx` (`factura_idfactura`),
  KEY `fk_detalle_factura_producto1_idx` (`producto_idproducto`),
  CONSTRAINT `fk_detalle_factura_factura1` FOREIGN KEY (`factura_idfactura`) REFERENCES `factura` (`idfactura`),
  CONSTRAINT `fk_detalle_factura_producto1` FOREIGN KEY (`producto_idproducto`) REFERENCES `producto` (`idproducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla sistema_veterinaria.detalle_factura: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `detalle_factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_factura` ENABLE KEYS */;

-- Volcando estructura para tabla sistema_veterinaria.detalle_producto
CREATE TABLE IF NOT EXISTS `detalle_producto` (
  `iddetalle_producto` int NOT NULL,
  `fechaingreso` date NOT NULL,
  `fechaexpira` date NOT NULL,
  `cantidadactual` int NOT NULL,
  `cantidadcomprada` int NOT NULL,
  `cantidadsalida` int NOT NULL,
  `fechasalida` date NOT NULL,
  `producto_idproducto` int NOT NULL,
  PRIMARY KEY (`iddetalle_producto`),
  KEY `fk_detalle_producto_producto1_idx` (`producto_idproducto`),
  CONSTRAINT `fk_detalle_producto_producto1` FOREIGN KEY (`producto_idproducto`) REFERENCES `producto` (`idproducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla sistema_veterinaria.detalle_producto: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `detalle_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_producto` ENABLE KEYS */;

-- Volcando estructura para tabla sistema_veterinaria.empleados
CREATE TABLE IF NOT EXISTS `empleados` (
  `idempleados` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `dni` int NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `cargo_idcargo` int NOT NULL,
  `codigo` int DEFAULT NULL,
  `clave` varchar(50) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idempleados`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  KEY `fk_empleados_cargo1_idx` (`cargo_idcargo`),
  CONSTRAINT `fk_empleados_cargo1` FOREIGN KEY (`cargo_idcargo`) REFERENCES `cargo` (`idcargo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla sistema_veterinaria.empleados: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` (`idempleados`, `nombre`, `apellido`, `dni`, `telefono`, `direccion`, `cargo_idcargo`, `codigo`, `clave`, `estado`) VALUES
	(1, 'Roger', 'Arias', 12345678, '985632147', 'Av.Bolognesi', 1, 123, '123', 'Activo');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;

-- Volcando estructura para tabla sistema_veterinaria.factura
CREATE TABLE IF NOT EXISTS `factura` (
  `idfactura` int NOT NULL,
  `fecha` date NOT NULL,
  `total` double NOT NULL,
  `igv` double NOT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `proveedor_idproveedor` int NOT NULL,
  `empleados_idempleados` int NOT NULL,
  PRIMARY KEY (`idfactura`),
  KEY `fk_factura_proveedor1_idx` (`proveedor_idproveedor`),
  KEY `fk_factura_empleados1_idx` (`empleados_idempleados`),
  CONSTRAINT `fk_factura_empleados1` FOREIGN KEY (`empleados_idempleados`) REFERENCES `empleados` (`idempleados`),
  CONSTRAINT `fk_factura_proveedor1` FOREIGN KEY (`proveedor_idproveedor`) REFERENCES `proveedor` (`idproveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla sistema_veterinaria.factura: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;

-- Volcando estructura para tabla sistema_veterinaria.historial_medico
CREATE TABLE IF NOT EXISTS `historial_medico` (
  `idhistorial_medico` int NOT NULL AUTO_INCREMENT,
  `mascota_idmascota` int NOT NULL,
  `empleados_idempleados` int NOT NULL,
  PRIMARY KEY (`idhistorial_medico`),
  KEY `fk_historial_medico_mascota1_idx` (`mascota_idmascota`),
  KEY `fk_historial_medico_empleados1_idx` (`empleados_idempleados`),
  CONSTRAINT `fk_historial_medico_empleados1` FOREIGN KEY (`empleados_idempleados`) REFERENCES `empleados` (`idempleados`),
  CONSTRAINT `fk_historial_medico_mascota1` FOREIGN KEY (`mascota_idmascota`) REFERENCES `mascota` (`idmascota`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla sistema_veterinaria.historial_medico: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `historial_medico` DISABLE KEYS */;
/*!40000 ALTER TABLE `historial_medico` ENABLE KEYS */;

-- Volcando estructura para tabla sistema_veterinaria.mascota
CREATE TABLE IF NOT EXISTS `mascota` (
  `idmascota` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `peso` double DEFAULT NULL,
  `especie` varchar(45) DEFAULT NULL,
  `sexo` varchar(1) DEFAULT NULL,
  `raza` varchar(45) DEFAULT NULL,
  `edad` varchar(45) DEFAULT NULL,
  `particularidades` varchar(150) DEFAULT NULL,
  `cliente_idCliente` int NOT NULL,
  PRIMARY KEY (`idmascota`),
  KEY `fk_mascota_cliente1_idx` (`cliente_idCliente`),
  CONSTRAINT `fk_mascota_cliente1` FOREIGN KEY (`cliente_idCliente`) REFERENCES `cliente` (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla sistema_veterinaria.mascota: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `mascota` DISABLE KEYS */;
/*!40000 ALTER TABLE `mascota` ENABLE KEYS */;

-- Volcando estructura para tabla sistema_veterinaria.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `idproducto` int NOT NULL,
  `codigo` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`idproducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla sistema_veterinaria.producto: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;

-- Volcando estructura para tabla sistema_veterinaria.proveedor
CREATE TABLE IF NOT EXISTS `proveedor` (
  `idproveedor` int NOT NULL,
  `ruc` int unsigned NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`idproveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla sistema_veterinaria.proveedor: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;

-- Volcando estructura para procedimiento sistema_veterinaria.USP_S_ListarEmpleados
DELIMITER //
CREATE PROCEDURE `USP_S_ListarEmpleados`()
BEGIN
SELECT * FROM empleados;
END//
DELIMITER ;

-- Volcando estructura para procedimiento sistema_veterinaria.USP_S_Login
DELIMITER //
CREATE PROCEDURE `USP_S_Login`(
	IN `PcodEmp` INT
)
BEGIN
SELECT codigo,clave,cargo_idCargo,estado FROM empleados WHERE codigo = PcodEmp;
END//
DELIMITER ;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
