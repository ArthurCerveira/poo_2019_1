# Repositório para o Trabalho Prático da disciplina de Programação Orientada a Objeto.

O trabalho consiste em um jogo CLI desenvolvido em java.

Nesse jogo, você é um pirata e recebeu a informação de que existe um tesouro a leste da ilha Kohoolawe. Seu objetivo é alcançar esse tesouro.
Ao longo do caminho você pode encontrar inimigos, mercadores e itens nas ilhas, que podem te ajudar a concluir seu objetivo.

Seus comandos são:
* sail + 'direção'
 - Navega na direção indicada até encontrar a próxima ilha
* quit
 - Sai do jogo
* help
 - Imprime as informações da sua localização e os comandos
* fight + 'nome do personagem'
 - Inicia um combate com um inimigo
* pick + 'nome do item'
 - Pega um item da sala e coloca no seu inventario
* drop + 'nome do item'
 - Pega um item do seu inventario e coloca na sala
* status
 - Imprime informações do seu personagem
* use + 'nome do item'
 - Usa um item que está no seu inventario
* shop
 - Se houver um mercador na sala, abre um menu para compra de itens. Para comprar, digite o nome do item desejado

Comandos dentro da batalha:
* attack ou a
 - Joga dados, quem tirar o maior número causa dano no adversario e ganha 1HP
* item ou i
 - Abre um menu de items, para utilizar um item digite seu nome ou 'back' para retornar
* run ou r
 - Possui 1/4 de chance de escapar, se falhar, o usuario perde 1HP
