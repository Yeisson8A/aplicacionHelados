create table Tipo_Helado
(
    Id_Tipo_Helado INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    Descripcion_Tipo_Helado VARCHAR(500),
    CONSTRAINT PK_Tipo_Helado PRIMARY KEY (Id_Tipo_Helado)
)

create table Sabor_Helado
(
    Id_Sabor_Helado INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    Descripcion_Sabor_Helado VARCHAR(500),
    CONSTRAINT PK_Sabor_Helado PRIMARY KEY (Id_Sabor_Helado)
)

create table Sabor_Tipo_Helado
(
    Id_Sabor_Tipo_Helado INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    Id_Tipo_Helado INT,
    Id_Sabor_Helado INT,
    CONSTRAINT PK_Sabor_Tipo_Helado PRIMARY KEY (Id_Sabor_Tipo_Helado)
)

alter table Sabor_Tipo_Helado add foreign key (Id_Tipo_Helado) references Tipo_Helado (Id_Tipo_Helado);
alter table Sabor_Tipo_Helado add foreign key (Id_Sabor_Helado) references Sabor_Helado (Id_Sabor_Helado);