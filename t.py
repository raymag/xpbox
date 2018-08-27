

while True:
      ouro = int(input("Ouro: "))
      prata = int(input("Prata: "))
      bronze = int(input("Bronze: "))

      totalPlayers = ouro+prata+bronze
      nTeams = int(totalPlayers/5)
      teams = []
      for i in range(nTeams):
            teams.append([0, 0, 0, 0, 0])
            #bronze, prata, ouro, pt, total
      for i in range(ouro):
            teams = sorted(teams, key=lambda x:x[3])
            teams[0][2] += 1
            teams[0][3] += 3
            teams[0][4] += 1
      print(teams)
      for i in range(prata):
            teams = sorted(teams, key=lambda x:x[3])
            teams[0][1] += 1
            teams[0][3] += 2
            teams[0][4] += 1
      print(teams)
      for i in range(bronze):
            teams = sorted(teams, key=lambda x:x[3])
            teams[0][0] += 1
            teams[0][3] += 1
            teams[0][4] += 1
      print(teams)
            
