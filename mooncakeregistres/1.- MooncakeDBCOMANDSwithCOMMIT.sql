-- OSORIO MOLLINEDO

-- Table: Cargos
CREATE TABLE Cargos (
    idCargo number(2,0)  NOT NULL,
    nombreCargo varchar2(30)  NOT NULL,
    CONSTRAINT Cargos_pk PRIMARY KEY (idCargo)
) ;

-- Table: Categorias
CREATE TABLE Categorias (
    idCategoria number(10,0)  NOT NULL,
    nombreCat varchar2(20)  NOT NULL,
    tipo smallint  NOT NULL,
    TiposCat_idTiposCat number(1,0)  NOT NULL,
    CONSTRAINT Categorias_pk PRIMARY KEY (idCategoria)
) ;

-- Table: Ciudades
CREATE TABLE Ciudades (
    idCiudad number(10,0)  NOT NULL,
    nombre varchar2(15)  NOT NULL,
    CONSTRAINT Ciudades_pk PRIMARY KEY (idCiudad)
) ;

-- Table: Clientes
CREATE TABLE Clientes (
    idCliente number(10,0)  NOT NULL,
    puntos integer  NOT NULL,
    Personas_idPersona number(10,0)  NOT NULL,
    CONSTRAINT Clientes_pk PRIMARY KEY (idCliente)
) ;

-- Table: Compra
CREATE TABLE Compra (
    idCompra number(10,0)  NOT NULL,
    fechaCompra date  NOT NULL,
    autorizacion varchar2(100)  NOT NULL,
    Proveedores_idProveedor number(10,0)  NOT NULL,
    Sucursales_idSucursal number(10,0)  NOT NULL,
    MetodosPago_idMetodo number(2,0)  NOT NULL,
    CONSTRAINT Compra_pk PRIMARY KEY (idCompra)
) ;

-- Table: DetalleCompra
CREATE TABLE DetalleCompra (
    idDetalleCompra number(10,0)  NOT NULL,
    unidades integer  NOT NULL,
    total integer  NOT NULL,
    Compra_idCompra number(10,0)  NOT NULL,
    producto number(10,0)  NOT NULL,
    CONSTRAINT DetalleCompra_pk PRIMARY KEY (idDetalleCompra)
) ;

-- Table: DetalleVenta
CREATE TABLE DetalleVenta (
    idDetalle number(10,0)  NOT NULL,
    unidades integer  NOT NULL,
    total integer  NOT NULL,
    Ventas_idVenta number(10,0)  NOT NULL,
    producto number(10,0)  NOT NULL,
    CONSTRAINT DetalleVenta_pk PRIMARY KEY (idDetalle)
) ;

-- Table: Direcciones
CREATE TABLE Direcciones (
    idDireccion number(10,0)  NOT NULL,
    calle varchar2(20)  NOT NULL,
    nro smallint  NOT NULL,
    Ciudades_idCiudad number(10,0)  NOT NULL,
    Zonas_idZona number(10,0)  NOT NULL,
    CONSTRAINT Direcciones_pk PRIMARY KEY (idDireccion)
) ;

-- Table: DireccionesPersonas
CREATE TABLE DireccionesPersonas (
    Direcciones_idDireccion number(10,0)  NOT NULL,
    Personas_idPersona number(10,0)  NOT NULL,
    CONSTRAINT DireccionesPersonas_pk PRIMARY KEY (Direcciones_idDireccion,Personas_idPersona)
) ;

-- Table: Empleados
CREATE TABLE Empleados (
    idEmpleado number(10,0)  NOT NULL,
    salario number(5,0)  NOT NULL,
    Personas_idPersona number(10,0)  NOT NULL,
    Estados_idEstado number(10,0)  NOT NULL,
    Cargos_idCargo number(1,0)  NOT NULL,
    Turnos_idTurno number(2,0)  NOT NULL,
    CONSTRAINT Empleados_pk PRIMARY KEY (idEmpleado)
) ;

-- Table: Estados
CREATE TABLE Estados (
    idEstado number(10,0)  NOT NULL,
    fechaInicio date  NOT NULL,
    fechaFin date  NOT NULL,
    tipoEstado_idTipo number(2,0)  NOT NULL,
    CONSTRAINT Estados_pk PRIMARY KEY (idEstado)
) ;

-- Table: EstadosCiviles
CREATE TABLE EstadosCiviles (
    idEstadoC number(2,0)  NOT NULL,
    nombreEstadoC varchar2(20)  NOT NULL,
    CONSTRAINT EstadosCiviles_pk PRIMARY KEY (idEstadoC)
) ;

-- Table: Generos
CREATE TABLE Generos (
    idGenero number(1,0)  NOT NULL,
    nombreGenero varchar2(10)  NOT NULL,
    CONSTRAINT Generos_pk PRIMARY KEY (idGenero)
) ;

-- Table: MetodosPago
CREATE TABLE MetodosPago (
    idMetodo number(2,0)  NOT NULL,
    nombreMet varchar2(10)  NOT NULL,
    CONSTRAINT MetodosPago_pk PRIMARY KEY (idMetodo)
) ;

-- Table: Paises
CREATE TABLE Paises (
    idPais number(3,0)  NOT NULL,
    nommbre varchar2(25)  NOT NULL,
    CONSTRAINT Paises_pk PRIMARY KEY (idPais)
) ;

-- Table: Personas
CREATE TABLE Personas (
    idPersona number(10,0)  NOT NULL,
    CI number(8,0)  NOT NULL,
    nombre varchar2(30)  NOT NULL,
    apPaterno varchar2(50)  NOT NULL,
    apMaterno varchar2(50)  NOT NULL,
    fechaNac date  NOT NULL,
    correo varchar2(50)  NOT NULL,
    Generos_idGenero number(1,0)  NOT NULL,
    EstadosCiviles_idEstadoC number(2,0)  NOT NULL,
    TiposPersonas_idTipoPersona number(1,0)  NOT NULL,
    CONSTRAINT Personas_pk PRIMARY KEY (idPersona)
) ;

-- Table: Presentaciones
CREATE TABLE Presentaciones (
    Productos_idProducto number(10,0)  NOT NULL,
    Unidades_idUnidad number(10,0)  NOT NULL,
    CONSTRAINT Presentaciones_pk PRIMARY KEY (Productos_idProducto,Unidades_idUnidad)
) ;

-- Table: Productos
CREATE TABLE Productos (
    idProducto number(10,0)  NOT NULL,
    nombreProd varchar2(30)  NOT NULL,
    descripcion varchar2(50)  NOT NULL,
    costo number(5,2)  NOT NULL,
    stock integer  NOT NULL,
    idCat_idCategoria number(10,0)  NOT NULL,
    isInv number(1,0)  NOT NULL,
    CONSTRAINT Productos_pk PRIMARY KEY (idProducto)
) ;

-- Table: Proveedores
CREATE TABLE Proveedores (
    idProveedor number(10,0)  NOT NULL,
    nit number(8,0)  NOT NULL,
    nombreProv varchar2(50)  NOT NULL,
    correo varchar2(30)  NOT NULL,
    url varchar2(50)  NOT NULL,
    idCat_idCategoria number(10,0)  NOT NULL,
    Paises_idPais number(3,0)  NOT NULL,
    Direcciones_idDireccion number(10,0)  NOT NULL,
    CONSTRAINT Proveedores_pk PRIMARY KEY (idProveedor)
) ;

-- Table: ProveedoresMetodos
CREATE TABLE ProveedoresMetodos (
    Proveedores_idProveedor number(10,0)  NOT NULL,
    MetodosPago_idMetodo number(2,0)  NOT NULL,
    CONSTRAINT ProveedoresMetodos_pk PRIMARY KEY (Proveedores_idProveedor)
) ;

-- Table: ProveedoresProductos
CREATE TABLE ProveedoresProductos (
    producto number(10,0)  NOT NULL,
    Producto_idProducto number(10,0)  NOT NULL,
    Proveedores_idProveedor number(10,0)  NOT NULL,
    CONSTRAINT ProveedoresProductos_pk PRIMARY KEY (producto)
) ;

-- Table: Sucursales
CREATE TABLE Sucursales (
    idSucursal number(10,0)  NOT NULL,
    nombreSucursal varchar2(20)  NOT NULL,
    Direcciones_idDireccion number(10,0)  NOT NULL,
    CONSTRAINT Sucursales_pk PRIMARY KEY (idSucursal)
) ;

-- Table: SucursalesEmpleados
CREATE TABLE SucursalesEmpleados (
    Empleados_idEmpleado number(10,0)  NOT NULL,
    Sucursales_idSucursal number(10,0)  NOT NULL,
    CONSTRAINT SucursalesEmpleados_pk PRIMARY KEY (Sucursales_idSucursal,Empleados_idEmpleado)
) ;

-- Table: SucursalesProductos
CREATE TABLE SucursalesProductos (
    idPrproducto number(10,0)  NOT NULL,
    Sucursales_idSucursal number(10,0)  NOT NULL,
    productoProveedor number(10,0)  NOT NULL,
    CONSTRAINT SucursalesProductos_pk PRIMARY KEY (idPrproducto)
) ;

-- Table: Telefonos
CREATE TABLE Telefonos (
    idTelefono number(10,0)  NOT NULL,
    telefono number(8,0)  NOT NULL,
    CONSTRAINT Telefonos_pk PRIMARY KEY (idTelefono)
) ;

-- Table: TelefonosPersonas
CREATE TABLE TelefonosPersonas (
    Personas_idPersona number(10,0)  NOT NULL,
    Telefonos_id_telefono number(10,0)  NOT NULL,
    CONSTRAINT TelefonosPersonas_pk PRIMARY KEY (Personas_idPersona,Telefonos_id_telefono)
) ;

-- Table: TelefonosProveedores
CREATE TABLE TelefonosProveedores (
    Telefonos_id_telefono number(10,0)  NOT NULL,
    Proveedores_idProveedor number(10,0)  NOT NULL,
    CONSTRAINT TelefonosProveedores_pk PRIMARY KEY (Proveedores_idProveedor,Telefonos_id_telefono)
) ;

-- Table: TelefonosaSucursales
CREATE TABLE TelefonosaSucursales (
    Sucursales_idSucursal number(10,0)  NOT NULL,
    Telefonos_id_telefono number(10,0)  NOT NULL,
    CONSTRAINT TelefonosaSucursales_pk PRIMARY KEY (Telefonos_id_telefono,Sucursales_idSucursal)
) ;

-- Table: TipoEstado
CREATE TABLE TipoEstado (
    idTipo number(2,0)  NOT NULL,
    nombre varchar2(20)  NOT NULL,
    CONSTRAINT TipoEstado_pk PRIMARY KEY (idTipo)
) ;

-- Table: TiposCat
CREATE TABLE TiposCat (
    idTiposCat number(1,0)  NOT NULL,
    nombreTipo varchar2(15)  NOT NULL,
    CONSTRAINT TiposCat_pk PRIMARY KEY (idTiposCat)
) ;

-- Table: TiposPersonas
CREATE TABLE TiposPersonas (
    idTipoPersona number(1,0)  NOT NULL,
    nombreTipo varchar2(45)  NOT NULL,
    CONSTRAINT TiposPersonas_pk PRIMARY KEY (idTipoPersona)
) ;

-- Table: Turnos
CREATE TABLE Turnos (
    idTurno number(2,0)  NOT NULL,
    horaInicio timestamp  NOT NULL,
    horaFin timestamp  NOT NULL,
    CONSTRAINT Turnos_pk PRIMARY KEY (idTurno)
) ;

-- Table: Unidades
CREATE TABLE Unidades (
    idUnidad number(10,0)  NOT NULL,
    nombre varchar2(10)  NOT NULL,
    CONSTRAINT Unidades_pk PRIMARY KEY (idUnidad)
) ;

-- Table: Usuarios
CREATE TABLE Usuarios (
    idUsuario number(10,0)  NOT NULL,
    usuario varchar2(30)  NOT NULL,
    contrasenia varchar2(30)  NOT NULL,
    Empleados_idEmpleado number(10,0)  NOT NULL,
    CONSTRAINT Usuarios_pk PRIMARY KEY (idUsuario)
) ;

-- Table: Ventas
CREATE TABLE Ventas (
    idVenta number(10,0)  NOT NULL,
    fechaVenta date  NOT NULL,
    autorizacion varchar2(100)  NOT NULL,
    descuento number(2,0)  NOT NULL,
    nroFactura number(10,0)  NOT NULL,
    Clientes_idCliente number(10,0)  NOT NULL,
    Usuarios_idUsuario number(10,0)  NOT NULL,
    Sucursales_idSucursal number(10,0)  NOT NULL,
    MetodosPago_idMetodo number(2,0)  NOT NULL,
    CONSTRAINT Ventas_pk PRIMARY KEY (idVenta)
) ;

-- Table: Zonas
CREATE TABLE Zonas (
    idZona number(10,0)  NOT NULL,
    nombreZona varchar2(20)  NOT NULL,
    CONSTRAINT Zonas_pk PRIMARY KEY (idZona)
) ;

-- foreign keys
-- Reference: Categorias_TiposCat (table: Categorias)
ALTER TABLE Categorias ADD CONSTRAINT Categorias_TiposCat
    FOREIGN KEY (TiposCat_idTiposCat)
    REFERENCES TiposCat (idTiposCat);

-- Reference: Clientes_Personas (table: Clientes)
ALTER TABLE Clientes ADD CONSTRAINT Clientes_Personas
    FOREIGN KEY (Personas_idPersona)
    REFERENCES Personas (idPersona);

-- Reference: CompraProductos (table: DetalleCompra)
ALTER TABLE DetalleCompra ADD CONSTRAINT CompraProductos
    FOREIGN KEY (producto)
    REFERENCES ProveedoresProductos (producto);

-- Reference: Compra_MetodosPago (table: Compra)
ALTER TABLE Compra ADD CONSTRAINT Compra_MetodosPago
    FOREIGN KEY (MetodosPago_idMetodo)
    REFERENCES MetodosPago (idMetodo);

-- Reference: Compra_Proveedores (table: Compra)
ALTER TABLE Compra ADD CONSTRAINT Compra_Proveedores
    FOREIGN KEY (Proveedores_idProveedor)
    REFERENCES Proveedores (idProveedor);

-- Reference: Compra_Sucursales (table: Compra)
ALTER TABLE Compra ADD CONSTRAINT Compra_Sucursales
    FOREIGN KEY (Sucursales_idSucursal)
    REFERENCES Sucursales (idSucursal);

-- Reference: DetalleCompra_Compra (table: DetalleCompra)
ALTER TABLE DetalleCompra ADD CONSTRAINT DetalleCompra_Compra
    FOREIGN KEY (Compra_idCompra)
    REFERENCES Compra (idCompra);

-- Reference: DetalleVenta_Ventas (table: DetalleVenta)
ALTER TABLE DetalleVenta ADD CONSTRAINT DetalleVenta_Ventas
    FOREIGN KEY (Ventas_idVenta)
    REFERENCES Ventas (idVenta);

-- Reference: DireccionesPersonas_Personas (table: DireccionesPersonas)
ALTER TABLE DireccionesPersonas ADD CONSTRAINT DireccionesPersonas_Personas
    FOREIGN KEY (Personas_idPersona)
    REFERENCES Personas (idPersona);

-- Reference: Direcciones_Ciudades (table: Direcciones)
ALTER TABLE Direcciones ADD CONSTRAINT Direcciones_Ciudades
    FOREIGN KEY (Ciudades_idCiudad)
    REFERENCES Ciudades (idCiudad);

-- Reference: Direcciones_Zonas (table: Direcciones)
ALTER TABLE Direcciones ADD CONSTRAINT Direcciones_Zonas
    FOREIGN KEY (Zonas_idZona)
    REFERENCES Zonas (idZona);

-- Reference: Empleados_Cargos (table: Empleados)
ALTER TABLE Empleados ADD CONSTRAINT Empleados_Cargos
    FOREIGN KEY (Cargos_idCargo)
    REFERENCES Cargos (idCargo);

-- Reference: Empleados_Estados (table: Empleados)
ALTER TABLE Empleados ADD CONSTRAINT Empleados_Estados
    FOREIGN KEY (Estados_idEstado)
    REFERENCES Estados (idEstado);

-- Reference: Empleados_Personas (table: Empleados)
ALTER TABLE Empleados ADD CONSTRAINT Empleados_Personas
    FOREIGN KEY (Personas_idPersona)
    REFERENCES Personas (idPersona);

-- Reference: Empleados_Turnos (table: Empleados)
ALTER TABLE Empleados ADD CONSTRAINT Empleados_Turnos
    FOREIGN KEY (Turnos_idTurno)
    REFERENCES Turnos (idTurno);

-- Reference: Estados_tipoEstado (table: Estados)
ALTER TABLE Estados ADD CONSTRAINT Estados_tipoEstado
    FOREIGN KEY (tipoEstado_idTipo)
    REFERENCES TipoEstado (idTipo);

-- Reference: InProductos (table: SucursalesProductos)
ALTER TABLE SucursalesProductos ADD CONSTRAINT InProductos
    FOREIGN KEY (productoProveedor)
    REFERENCES ProveedoresProductos (producto);

-- Reference: Personas_Direcciones (table: DireccionesPersonas)
ALTER TABLE DireccionesPersonas ADD CONSTRAINT Personas_Direcciones
    FOREIGN KEY (Direcciones_idDireccion)
    REFERENCES Direcciones (idDireccion);

-- Reference: Personas_EstadosCiviles (table: Personas)
ALTER TABLE Personas ADD CONSTRAINT Personas_EstadosCiviles
    FOREIGN KEY (EstadosCiviles_idEstadoC)
    REFERENCES EstadosCiviles (idEstadoC);

-- Reference: Personas_Generos (table: Personas)
ALTER TABLE Personas ADD CONSTRAINT Personas_Generos
    FOREIGN KEY (Generos_idGenero)
    REFERENCES Generos (idGenero);

-- Reference: Personas_TiposPersonas (table: Personas)
ALTER TABLE Personas ADD CONSTRAINT Personas_TiposPersonas
    FOREIGN KEY (TiposPersonas_idTipoPersona)
    REFERENCES TiposPersonas (idTipoPersona);

-- Reference: Producto_idCat (table: Productos)
ALTER TABLE Productos ADD CONSTRAINT Producto_idCat
    FOREIGN KEY (idCat_idCategoria)
    REFERENCES Categorias (idCategoria);

-- Reference: ProveedorMetodo_Proveedores (table: ProveedoresMetodos)
ALTER TABLE ProveedoresMetodos ADD CONSTRAINT ProveedorMetodo_Proveedores
    FOREIGN KEY (Proveedores_idProveedor)
    REFERENCES Proveedores (idProveedor);

-- Reference: ProveedorProducto_Producto (table: ProveedoresProductos)
ALTER TABLE ProveedoresProductos ADD CONSTRAINT ProveedorProducto_Producto
    FOREIGN KEY (Producto_idProducto)
    REFERENCES Productos (idProducto);

-- Reference: ProveedorProducto_Proveedores (table: ProveedoresProductos)
ALTER TABLE ProveedoresProductos ADD CONSTRAINT ProveedorProducto_Proveedores
    FOREIGN KEY (Proveedores_idProveedor)
    REFERENCES Proveedores (idProveedor);

-- Reference: ProveedoresMetodos_MetodosPago (table: ProveedoresMetodos)
ALTER TABLE ProveedoresMetodos ADD CONSTRAINT ProveedoresMetodos_MetodosPago
    FOREIGN KEY (MetodosPago_idMetodo)
    REFERENCES MetodosPago (idMetodo);

-- Reference: Proveedores_Direcciones (table: Proveedores)
ALTER TABLE Proveedores ADD CONSTRAINT Proveedores_Direcciones
    FOREIGN KEY (Direcciones_idDireccion)
    REFERENCES Direcciones (idDireccion);

-- Reference: Proveedores_Paises (table: Proveedores)
ALTER TABLE Proveedores ADD CONSTRAINT Proveedores_Paises
    FOREIGN KEY (Paises_idPais)
    REFERENCES Paises (idPais);

-- Reference: Proveedores_idCat (table: Proveedores)
ALTER TABLE Proveedores ADD CONSTRAINT Proveedores_idCat
    FOREIGN KEY (idCat_idCategoria)
    REFERENCES Categorias (idCategoria);

-- Reference: SucursalEmpleado_Empleados (table: SucursalesEmpleados)
ALTER TABLE SucursalesEmpleados ADD CONSTRAINT SucursalEmpleado_Empleados
    FOREIGN KEY (Empleados_idEmpleado)
    REFERENCES Empleados (idEmpleado);

-- Reference: SucursalEmpleado_Sucursales (table: SucursalesEmpleados)
ALTER TABLE SucursalesEmpleados ADD CONSTRAINT SucursalEmpleado_Sucursales
    FOREIGN KEY (Sucursales_idSucursal)
    REFERENCES Sucursales (idSucursal);

-- Reference: SucursalProducto_Sucursales (table: SucursalesProductos)
ALTER TABLE SucursalesProductos ADD CONSTRAINT SucursalProducto_Sucursales
    FOREIGN KEY (Sucursales_idSucursal)
    REFERENCES Sucursales (idSucursal);

-- Reference: Sucursales_Direcciones (table: Sucursales)
ALTER TABLE Sucursales ADD CONSTRAINT Sucursales_Direcciones
    FOREIGN KEY (Direcciones_idDireccion)
    REFERENCES Direcciones (idDireccion);

-- Reference: TelefonoProveedor_Proveedores (table: TelefonosProveedores)
ALTER TABLE TelefonosProveedores ADD CONSTRAINT TelefonoProveedor_Proveedores
    FOREIGN KEY (Proveedores_idProveedor)
    REFERENCES Proveedores (idProveedor);

-- Reference: TelefonoProveedor_Telefonos (table: TelefonosProveedores)
ALTER TABLE TelefonosProveedores ADD CONSTRAINT TelefonoProveedor_Telefonos
    FOREIGN KEY (Telefonos_id_telefono)
    REFERENCES Telefonos (idTelefono);

-- Reference: TelefonoSucursal_Sucursales (table: TelefonosaSucursales)
ALTER TABLE TelefonosaSucursales ADD CONSTRAINT TelefonoSucursal_Sucursales
    FOREIGN KEY (Sucursales_idSucursal)
    REFERENCES Sucursales (idSucursal);

-- Reference: TelefonoSucursal_Telefonos (table: TelefonosaSucursales)
ALTER TABLE TelefonosaSucursales ADD CONSTRAINT TelefonoSucursal_Telefonos
    FOREIGN KEY (Telefonos_id_telefono)
    REFERENCES Telefonos (idTelefono);

-- Reference: TelefonosPersona_Personas (table: TelefonosPersonas)
ALTER TABLE TelefonosPersonas ADD CONSTRAINT TelefonosPersona_Personas
    FOREIGN KEY (Personas_idPersona)
    REFERENCES Personas (idPersona);

-- Reference: TelefonosPersona_Telefonos (table: TelefonosPersonas)
ALTER TABLE TelefonosPersonas ADD CONSTRAINT TelefonosPersona_Telefonos
    FOREIGN KEY (Telefonos_id_telefono)
    REFERENCES Telefonos (idTelefono);

-- Reference: Usuarios_Empleados (table: Usuarios)
ALTER TABLE Usuarios ADD CONSTRAINT Usuarios_Empleados
    FOREIGN KEY (Empleados_idEmpleado)
    REFERENCES Empleados (idEmpleado);

-- Reference: VentaProductos (table: DetalleVenta)
ALTER TABLE DetalleVenta ADD CONSTRAINT VentaProductos
    FOREIGN KEY (producto)
    REFERENCES SucursalesProductos (idPrproducto);

-- Reference: Ventas_Clientes (table: Ventas)
ALTER TABLE Ventas ADD CONSTRAINT Ventas_Clientes
    FOREIGN KEY (Clientes_idCliente)
    REFERENCES Clientes (idCliente);

-- Reference: Ventas_MetodosPago (table: Ventas)
ALTER TABLE Ventas ADD CONSTRAINT Ventas_MetodosPago
    FOREIGN KEY (MetodosPago_idMetodo)
    REFERENCES MetodosPago (idMetodo);

-- Reference: Ventas_Sucursales (table: Ventas)
ALTER TABLE Ventas ADD CONSTRAINT Ventas_Sucursales
    FOREIGN KEY (Sucursales_idSucursal)
    REFERENCES Sucursales (idSucursal);

-- Reference: Ventas_Usuarios (table: Ventas)
ALTER TABLE Ventas ADD CONSTRAINT Ventas_Usuarios
    FOREIGN KEY (Usuarios_idUsuario)
    REFERENCES Usuarios (idUsuario);

-- Reference: producUnidad_Productos (table: Presentaciones)
ALTER TABLE Presentaciones ADD CONSTRAINT producUnidad_Productos
    FOREIGN KEY (Productos_idProducto)
    REFERENCES Productos (idProducto);

-- Reference: producUnidad_Unidades (table: Presentaciones)
ALTER TABLE Presentaciones ADD CONSTRAINT producUnidad_Unidades
    FOREIGN KEY (Unidades_idUnidad)
    REFERENCES Unidades (idUnidad);

COMMIT;
-- End of file.

