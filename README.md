# DigitalBank - API para registro de clientes de um banco digital..


#Usando Swagger para testes com login Default = admin senha = 123

PRIMEIRAMENTE DEVE-SE ADICIONAR O CLIENTE COM JSON CORRETAMENTE NO FORMATO
ONDE CPF DEVE CONTER OS NUMEROS PONTOS E TRAÇOS COMO ESSE EXEMPLO "cpf": "456.456.456-75"

A DATA DE NASCIMENTO É DO TIPO LOCALDATE: EXEMPLO "dataNascimento": "2000-10-10"

EMAIL NÃO PODE SER NULO, DEVE SER NO FORMATO E-MAIL E NÃO PODE SER REPETIDO "email": "mateus@medeiros.com"

O ID DO CLIENTE É AUTOINCREMETAVEL NO BANCO SENDO ASSIM VC COLOCANDO NO JSON NÃO INTERFERE 

APÓS DEVE INSERIR O NOME, UNICA RESTRIÇÃO É NOTBLANK EXEMPLO "nome": "Mateus"

E POR ULTIMO DESTA ETAPA DEVE INSERIR O SOBRENOME EXEMPLO "sobrenome": "Medeiros",

exemplo completo Json 

{
  "cpf": "456.456.456-75",
  "dataNascimento": "2000-10-10",
  "email": "mateus@medeiros.com",
  "idClient": 0,
  "nome": "Mateus",
  "sobrenome": "Medeiros"
}


-------------------------------- ETAPA 2 -------------------------------------------------

PARA SEGUIR NESSA ETAPA DEVE TER CONCLUIDO A PRIMEIRA, NO HEADER TERA UMA RESPOSTA COMO TOKEN PARA SEGUNDA PARTE
DEVE TAMBEM COMO PARAMETRO INSERIR O ID DO CLIENTE ASSOCIADO A ESSE ENDEREÇO. 
ENTÃO TODOS OS DADOS NO FORMATO STRING VAMOS INSERIR CONFORME EXEMPLO (OBS: CEP DEVE ESTAR NO FORMATO)
{
  "bairro": "Jardim",
  "cep": "89460-000",
  "cidade": "Canoinhas",
  "complemento": "casa",
  "estado": "SC",
  "rua": "Carmelitas"
}


-------------------------------- ETAPA 3 -------------------------------------------------

COMO NA PRIMEIRA ETAPA A SEGUNDA ETAPA GERA UM TOKEN (não é igual da primeira etapa) NO HEADER
PARA QUE COM ESSE TOKEN O USUARIO CONSIGA FAZER O UPLOAD DO SEU CPF(imagem) PARA O SETOR RESPONSÁVEL
VERIFICAR O DOCUMENTO. 

AS IMAGENS NÃO TEM RESTRIÇÕES SOMENTE DEVE INSERIR O TOKEN E O ID DO CLIENTE QUE CORRESPONDE A IMAGEM

-------------------------------- ETAPA 4 -------------------------------------------------

AGORA TEMOS O RETORNO DO JSON TAMBÉM COM AUTORIZAÇÃO VIA TOKEN VINDO DA ETAPA 3, OS DADOS SÃO RETORNADOS
PARA CONFIRMAÇÃO DO USUÁRIO... 


-------------------------------- ETAPA 4 -------------------------------------------------

????
