
public abstract class PessoaBase {
        //private static int count = 0;
        private int id;
        private String nome;
        private String endereco;
        private String telefone;

        public PessoaBase() {
        	//count++;
        	//id = count;
        	
        }
        
        public PessoaBase(int id, String nome, String endereco, String telefone) {
        	this.id = id;
        	this.nome = nome;
        	this.endereco = endereco;
        	this.telefone = telefone;
        	//count++;
        	//id = count;
        }

        public int getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEndereco() {
            return endereco;
        }
        
        public void setId(int id) {
        	this.id = id;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }
    }
