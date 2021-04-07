#language:pt
#encoding:Cp1252


Funcionalidade:Consulta de Curso
@web @Teste
Cenario: Caminho Feliz 
	 Dado o cliente acessa site da iterasys
	 Quando realizo uma consulta por "inicio rapido"
	 Entao exibe o cursos
	 Quando clico no curso inicio rapido em Teste de sofftware
	 Entao valido que a duracao do curso sera de "090 Horas de duração" hora