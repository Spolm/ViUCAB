CREATE TABLE USUARIO(
    USU_ID INTEGER PRIMARY KEY,
    USU_LOGIN VARCHAR(50) NOT NULL,
    USU_CLAVE VARCHAR(50) NOT NULL,
    USU_TOKEN VARCHAR(250) NOT NULL,
    USU_ACT BOOLEAN NOT NULL,
    USU_CORREO VARCHAR(100)NOT NULL,
    USU_AVATAR VARCHAR(1000)NOT NULL
);
CREATE TABLE CATEGORIA(
    CAT_ID INTEGER PRIMARY KEY,
    CAT_VALOR VARCHAR(50) NOT NULL
);
CREATE TABLE ETIQUETA(
    ETI_ID INTEGER PRIMARY KEY,
    ETI_VALOR VARCHAR(100) NOT NULL
);
CREATE TABLE VIDEO (
    VID_ID INTEGER PRIMARY KEY,
    VID_TITULO VARCHAR(100) NOT NULL,
    VID_DESCRIPCION VARCHAR(2000) NOT NULL,
    VID_IMAGEN VARCHAR(1000) NOT NULL,
    VID_URL VARCHAR(1000) NOT NULL,
    VID_FECHA DATE NOT NULL,
    VID_VISITAS INTEGER NOT NULL,
	VID_USUARIO INTEGER NOT NULL,
    --ID_CAT INTEGER NOT NULL,
    CONSTRAINT FK_USU FOREIGN KEY (VID_USUARIO)
	REFERENCES USUARIO (USU_ID)
    --CONSTRAINT FK_CAT FOREIGN KEY(ID_CAT)
    --    REFERENCES CATEGORIA(CAT_ID)
);

CREATE TABLE VIDEO_CAT (
    IDVID INTEGER,
    IDCAT INTEGER,
    
    CONSTRAINT PK_VIDEO_CAT 
        PRIMARY KEY(IDVID,IDCAT),
    
    CONSTRAINT FK_VID FOREIGN KEY(IDVID) 
        REFERENCES VIDEO(VID_ID),
    
    CONSTRAINT FK_CAT FOREIGN KEY (IDCAT)
        REFERENCES CATEGORIA(CAT_ID)
);

CREATE TABLE VIDEO_ETIQ (
    IDVID INTEGER,
    IDETIQ INTEGER,
    
    CONSTRAINT PK_VIDEO_ETIQ 
        PRIMARY KEY(IDVID,IDETIQ),
    
    CONSTRAINT FK_VID FOREIGN KEY(IDVID) 
        REFERENCES VIDEO(VID_ID),
    
    CONSTRAINT FK_ETIQ FOREIGN KEY (IDETIQ)
        REFERENCES ETIQUETA(ETI_ID)
);
CREATE TABLE LISTA_REPRODUCCION(
    LIS_REP_ID INTEGER PRIMARY KEY,
    LIS_REP_NOMBRE VARCHAR(100) NOT NULL,
    LIS_REP_DESCRIPCION VARCHAR(500) NOT NULL,
    LIS_REP_IMG BYTEA NOT NULL,
    LIS_REP_NUMREP INTEGER NOT NULL,
    LIS_REP_FECHA DATE NOT NULL,
    ID_USU INTEGER NOT NULL,
    
    CONSTRAINT FK_USU_LISTA FOREIGN KEY(ID_USU) 
        REFERENCES USUARIO(USU_ID)
);
CREATE TABLE VIDEO_LISTA(
    ID_VID INTEGER,
    ID_LIS INTEGER,
    
    CONSTRAINT PK_VID_LIS PRIMARY KEY (ID_VID,ID_LIS),
    
    CONSTRAINT FK_VID FOREIGN KEY(ID_VID)
        REFERENCES VIDEO(VID_ID),
    
    CONSTRAINT FK_LIS FOREIGN KEY(ID_LIS)
        REFERENCES LISTA_REPRODUCCION(LIS_REP_ID)
);
CREATE TABLE COMENTARIO(
    COM_ID INTEGER NOT NULL,
    COM_DESCRIPCION VARCHAR(5000) NOT NULL,
    ID_USU INTEGER,
    ID_VID INTEGER,
    
    CONSTRAINT PK_USU_COM_VID PRIMARY KEY(COM_ID,ID_USU,ID_VID),
    
    CONSTRAINT FK_USU_COM FOREIGN KEY(ID_USU)
        REFERENCES USUARIO(USU_ID),
    
   CONSTRAINT FK_VID_COM FOREIGN KEY(ID_VID)
        REFERENCES VIDEO(VID_ID)
);
CREATE TABLE SUSCRIPCION(
    ID_SUSCRIPTOR INTEGER,
    ID_SUSCRIPCION INTEGER,
    
    CONSTRAINT PF_SUSCRIPTOR_SUSCRIPCION 
        PRIMARY KEY (ID_SUSCRIPTOR,ID_SUSCRIPCION),
    
    CONSTRAINT FK_SUSCRIPTOR FOREIGN KEY(ID_SUSCRIPTOR)
        REFERENCES USUARIO(USU_ID),
    
    CONSTRAINT FK_SUSCRIPCION FOREIGN KEY(ID_SUSCRIPCION)
        REFERENCES USUARIO(USU_ID)
);
CREATE TABLE CONFIG_NOTIFICACION(
    CON_NOT_ID INTEGER NOT NULL,
    CON_NOT_RECIBIR BOOLEAN NOT NULL,
    CON_NOT_BOLETIN BOOLEAN NOT NULL,
    CON_NOT_PREFERENCIAS BOOLEAN NOT NULL,
    CON_NOT_SUSCRIPCIONES BOOLEAN NOT NULL,
    CON_NOT_ETIQUETADO BOOLEAN NOT NULL,
    CON_NOT_ESTADISTICAS BOOLEAN NOT NULL,
    USU_ID INTEGER NOT NULL,
    CONSTRAINT PK_CONFIG_NOT 
        PRIMARY KEY(CON_NOT_ID,USU_ID),
    
    CONSTRAINT FK_USU FOREIGN KEY(USU_ID)
        REFERENCES USUARIO(USU_ID)
);
CREATE TABLE NOTIFICACION(
    NOT_ID INTEGER NOT NULL,
    NOT_ASUNTO VARCHAR(100) NOT NULL,
    NOT_FECHA DATE NOT NULL,
    NOT_TITULO VARCHAR(20) NOT NULL,
    NOT_MENSAJE VARCHAR(100) NOT NULL,
    NOT_DESECHADO BOOLEAN NOT NULL,
    USU_ID INTEGER NOT NULL,
    
    CONSTRAINT PK_NOTIG 
        PRIMARY KEY (NOT_ID,NOT_ASUNTO,NOT_FECHA,USU_ID),
    
    CONSTRAINT FK_USU FOREIGN KEY(USU_ID)
        REFERENCES USUARIO(USU_ID)
);
CREATE TABLE PRIVACIDAD(
    PRIV_ID INTEGER PRIMARY KEY,
    ID_VID INTEGER,
    
    CONSTRAINT FK_VIDEO FOREIGN KEY(ID_VID)
        REFERENCES VIDEO(VID_ID)
);
CREATE TABLE USUARIO_PRIVACIDAD(
    ID_USU INTEGER NOT NULL,
    ID_PRI INTEGER NOT NULL,
    
    CONSTRAINT PK_USU_PRIV PRIMARY KEY(ID_USU,ID_PRI),
    
    CONSTRAINT FK_USU FOREIGN KEY(ID_USU)
        REFERENCES USUARIO(USU_ID),
    
    CONSTRAINT FK_PRI FOREIGN KEY(ID_PRI)
        REFERENCES PRIVACIDAD(PRIV_ID)
);
CREATE TABLE FILTRO(
    FIL_ID INTEGER PRIMARY KEY,
    FIL_TIPO VARCHAR(20) NOT NULL,
    FIL_DESCRICION VARCHAR(100) NOT NULL,
    FIL_ID_FIL INTEGER,
    
    CONSTRAINT FK_FILTRO FOREIGN KEY(FIL_ID_FIL)
        REFERENCES FILTRO(FIL_ID)
);
CREATE TABLE USU_FIL(
    ID_FIL INTEGER NOT NULL,
    ID_USU INTEGER NOT NULL,
    
    CONSTRAINT PK_USU_FIL PRIMARY KEY(ID_FIL,ID_USU),
    
    CONSTRAINT FK_FIL FOREIGN KEY(ID_FIL)
        REFERENCES FILTRO(FIL_ID),
    
    CONSTRAINT FK_USU FOREIGN KEY(ID_USU)
        REFERENCES USUARIO(USU_ID)
);
CREATE TABLE CAT_FIL_ETIQ(
    ID_CAT INTEGER NOT NULL,
    ID_FIL INTEGER NOT NULL,
    ID_ETIQ INTEGER,
    
    CONSTRAINT PK_FIL_CAT PRIMARY KEY(ID_CAT,ID_FIL),
    
    CONSTRAINT FK_CAT FOREIGN KEY(ID_CAT)
        REFERENCES CATEGORIA(CAT_ID),
    
    CONSTRAINT FK_FIL FOREIGN KEY(ID_FIL)
        REFERENCES FILTRO(FIL_ID),
    
    CONSTRAINT FK_ETIQ FOREIGN KEY(ID_ETIQ)
        REFERENCES ETIQUETA(ETI_ID)
);
CREATE TABLE PREFERENCIA(
    ID_USU INTEGER NOT NULL,
    ID_CAT INTEGER NOT NULL,
    
    CONSTRAINT PK_PREFERENCIA PRIMARY KEY(ID_USU,ID_CAT),
    
    CONSTRAINT FK_USU FOREIGN KEY(ID_USU)
        REFERENCES USUARIO(USU_ID),
    CONSTRAINT FK_CAT FOREIGN KEY(ID_CAT)
        REFERENCES CATEGORIA(CAT_ID)
);

CREATE TABLE LIKES(
    ID_USUARIO INTEGER NOT NULL,
    ID_VIDEO INTEGER NOT NULL,
     CONSTRAINT PK_LIKE PRIMARY KEY(ID_USUARIO,ID_VIDEO),
    CONSTRAINT FK_LIKE_USER FOREIGN KEY (ID_USUARIO) 
        REFERENCES USUARIO(USU_ID), 
    CONSTRAINT FK_LIKE_VIDEO FOREIGN KEY (ID_VIDEO) 
        REFERENCES VIDEO(VID_ID) 
)
