import os
import subprocess

def molde(extensao):
      base = open("formats\\"+extensao+'.txt',  'r')
      return base.readlines()
      #print('\n', data, '\n')

def mono_file(): #Sequencia unica de arquivos
      print('_'*40)
      try:
            prefixo = "q"
            arquivos_criados = 0
            diretorio = input("Nome do diretorio de armazenamento a ser criado: ")
            qnt_arquivos = int(input("Quantidade de arquivos a serem criados:  "))
            extensao = input("Extensao dos arquivos: ")
            if (extensao[0] == '.'):
                  extensao = extensao[1:]
            try:
                  os.mkdir(diretorio)
            except:
                  print('\n Diretorio ja existente. \n')
                  q = input('Prosseguir? s/n  ').lower()
                  if(q=='s'):
                        pass
                  else:
                        interface()
            for i in range(qnt_arquivos):
                  file = open(diretorio+'\\'+prefixo+str(arquivos_criados+1)+'.'+extensao, 'w')
                  if(os.path.exists('formats\\')):
                        if(os.path.exists('formats\\'+extensao+'.txt')):
                              base = molde(extensao)
                              file.writelines(base)
                  else:
                         os.mkdir('formats')
                  file.close()
                  arquivos_criados+=1
            print('\n Operacao concluida com sucesso.', arquivos_criados, 'arquivos  foram criados no total')
            command = input('Ver diretorio: s/n  ').lower()
            if(command == 's'):
                  path = os.getcwd()+'\\'+diretorio+'\\'
                  subprocess.Popen(r'explorer /select, "'+path+'"')
      except:
            print('Impossível \n')

def bi_file_A(): #sequencia dupla de arquivos e de unica extensao
      print('_'*40)
      try:
            prefixo = "q"
            subtipo = "_server"
            arquivos_criados = 0
            diretorio = input("Nome do diretorio de armazenamento a ser criado: ")
            qnt_arquivos = int(input("Quantidade de arquivos a serem criados:  "))
            extensao = input("Extensao dos arquivos: ")
            if (extensao[0] == '.'):
                  extensao = extensao[1:]
            try:
                  os.mkdir(diretorio)
            except:
                  print('\n Diretorio ja existente. \n')
                  q = input('Prosseguir? s/n  ').lower()
                  if(q=='s'):
                        pass
                  else:
                        interface()
            for i in range(qnt_arquivos):
                  file = open(diretorio+'\\'+prefixo+str(arquivos_criados+1)+'.'+extensao, 'w')
                  if(os.path.exists('formats\\')):
                        if(os.path.exists('formats\\'+extensao+'.txt')):
                              base = molde(extensao)
                              file.writelines(base)
                  else:
                         os.mkdir('formats')
                  file.close()
                  file = open(diretorio+'\\'+prefixo+str(arquivos_criados+1)+subtipo+'.'+extensao, 'w')
                  file.writelines(base)
                  file.close()
                  arquivos_criados+=1
            print('\n Operacao concluida com sucesso.', arquivos_criados, 'arquivos  foram criados no total')
            command = input('Ver diretorio: s/n  ').lower()
            if(command == 's'):
                  path = os.getcwd()+'\\'+diretorio+'\\'
                  subprocess.Popen(r'explorer /select, "'+path+'"')
      except:
            print('Impossível \n')

def bi_file_B(): #sequencia dupla de arquivos e dupla extensao
      print('_'*40)
      try:
            prefixo = "q"
            subtipo = "_server"
            arquivos_criados = 0
            diretorio = input("Nome do diretorio de armazenamento a ser criado: ")
            qnt_arquivos = int(input("Quantidade de arquivos a serem criados:  "))
            extensao = input("Extensao dos arquivos A: ")
            extensaoB = input("Extensao dos arquivos B: ")
            if (extensao[0] == '.'):
                  extensao = extensao[1:]
            try:
                  os.mkdir(diretorio)
            except:
                  print('\n Diretorio ja existente. \n')
                  q = input('Prosseguir? s/n  ').lower()
                  if(q=='s'):
                        pass
                  else:
                        interface()
            for i in range(qnt_arquivos):
                  file = open(diretorio+'\\'+prefixo+str(arquivos_criados+1)+'.'+extensao, 'w')
                  if(os.path.exists('formats\\')):
                        if(os.path.exists('formats\\'+extensao+'.txt')):
                              base = molde(extensao)
                              file.writelines(base)
                  else:
                         os.mkdir('formats')
                  file.close()
                  file = open(diretorio+'\\'+prefixo+str(arquivos_criados+1)+subtipo+'.'+extensaoB, 'w')
                  if(os.path.exists('formats\\')):
                        if(os.path.exists('formats\\'+extensaoB+'.txt')):
                              base = molde(extensaoB)
                              file.writelines(base)
                  else:
                         os.mkdir('formats')
                  file.close()
                  arquivos_criados+=1
            print('\n Operacao concluida com sucesso.', arquivos_criados, 'arquivos  foram criados no total')
            command = input('Ver diretorio: s/n  ').lower()
            if(command == 's'):
                  path = os.getcwd()+'\\'+diretorio+'\\'
                  subprocess.Popen(r'explorer /select, "'+path+'"')
      except:
            print('Impossível \n')

def helpme():
      print('_'*40, '\n')
      print('***FileWriter - Escritor de Arquivos***')
      print('='*15, '==== Coded by Magno ===', '='*15, '\n')
      print("""
Este programa tem o intuito de facilitar a criacao
de uma sequencia de arquivos de padroes e extensoes
semelhantes em um mesmo diretorio. \n
Para usa-lo, escolha uma das opcoes da interface inicial.
""")
      input("Tecle enter para continuar ")
      print("""
\n
Sequencia de Mono-Arquivos: Cria uma sequencia de  X arquivos com o prefixo 'q' e
extensao desejada.
\n
Sequencia de BiArquivos: Cria uma dupla sequencia de  X arquivos com o prefixo 'q' e
extensao desejada, ex: q1.txt e q1_server.txt.
\n
Sequencia de BiArquivos e BiTipos: Cria uma dupla sequencia de X arquivos com o prefixo 'q'
e extensoes diferentes ou nao para cada sequencia.
\n
""")
      input()
      interface()


def interface(): #interface inicial
      while True:
            print('_'*40)
            print("""
1 - Sequencia de Mono-Arquivos
2- Sequencia de BiArquivos 
3- Sequencia de BiArquivos e BiTipos
4- Ajuda
""")
            try:
                  command = int(input("Criar:  "))
                  if(command==1):
                        mono_file()
                  elif(command==2):
                        bi_file_A()
                  elif(command==3):
                        bi_file_B()
                  else:
                        helpme()
            except:
                  print("Comando inválido")

interface()
