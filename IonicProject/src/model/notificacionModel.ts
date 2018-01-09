export class Notificacion {
    public id: number;
    public fecha: Date;
    public desechado: boolean;
    public video: {
      id: number,
      nombre: string,
      url: string,
      imagen: string,
      descripcion: string,
    };
    public usuario: {
      _name_user: string,
    };
}
