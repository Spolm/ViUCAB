package edu.ucab.desarrollo.viucab.common.entities;

/**
 *Patron Entidad creada por M011
 */
//[@Serializable]
public class Entity {



        /***
         * atributos de la clase padre entidad
         */
        protected int _id;
        private String _cadena;
        private int _errorCode1;
        private String _errorMsg1;


        public Entity() {
        }


        public Entity(String _cadena) {
                this._cadena = _cadena;
        }
        public Entity(int _id) {
                this._id = _id;
        }

        public int get_id() {
                return _id;
        }

        public void set_id(int _id) {
                this._id = _id;
        }

        public void set_errorCode( int _errorCode )
        {
                this._errorCode1 = _errorCode;
        }

        public String get_errorMsg()
        {
                return _errorMsg1;
        }

        public void set_errorMsg( String _errorMsg )
        {
                this._errorMsg1 = _errorMsg;
        }
        public int get_errorCode()
        {
                return _errorCode1;
        }

        public String get_cadena() {
                return _cadena;
        }

        public void set_cadena(String _cadena) {
                this._cadena = _cadena;
        }
}
