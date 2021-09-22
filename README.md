# Curso Betha Code (aula 17) Banco de dados JDBC
Este repositório é referente a aula 17 (18/09/2021) do curso Betha Code, onde aprendemos sobre Banco de dados com JDBC.

# Tabelas do projeto

    -- Table: public.aluno
    
    -- DROP TABLE public.aluno;
    
    CREATE TABLE public.aluno
    (
        id integer NOT NULL DEFAULT nextval('aluno_id_seq'::regclass),
        nome character varying(80) COLLATE pg_catalog."default" NOT NULL,
        idade integer NOT NULL,
        cidade character(30) COLLATE pg_catalog."default" NOT NULL,
        estado character(2) COLLATE pg_catalog."default" NOT NULL,
        CONSTRAINT aluno_pkey PRIMARY KEY (id)
    )
    
    TABLESPACE pg_default;
    
    ALTER TABLE public.aluno
        OWNER to postgres;

Referências para estudo:

[https://www.youtube.com/watch?v=P-psR8L9zUI](https://www.youtube.com/watch?v=P-psR8L9zUI)  [http://www.universidadejava.com.br/java/java-jdbc/](http://www.universidadejava.com.br/java/java-jdbc/)  [https://www.devmedia.com.br/aprendendo-java-com-jdbc/29116](https://www.devmedia.com.br/aprendendo-java-com-jdbc/29116)  

 
