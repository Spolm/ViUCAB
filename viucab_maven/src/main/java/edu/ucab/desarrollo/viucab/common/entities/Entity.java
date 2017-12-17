package edu.ucab.desarrollo.viucab.common.entities;

/**
 *Patron Entidad creada por M011
 * Objeto que que se usara entodo el flujo de patrones
 */
public class Entity {


        /***
         * atributos de la clase padre entidad
         */
        private int _id;


        public Entity (){}

        public Entity(int _id){
                this._id=_id;
        }

        public int get_id() {
                return _id;
        }

        public void set_id(int _id) {
                this._id = _id;
        }

}
