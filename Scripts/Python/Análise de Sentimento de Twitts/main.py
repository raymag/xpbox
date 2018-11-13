from textblob import TextBlob
from TwitterAPI import TwitterAPI

consumer_key = "****"
consumer_secret = "****"
access_token_key = "****"
access_token_secret = "****"
api = TwitterAPI(consumer_key,
                 consumer_secret,
                 access_token_key,
                 access_token_secret)

def main():
         tema = input("Tema: ")
         r = api.request('search/tweets', {'q':tema,'l':'pt'})
         polarity = 0
         subjectivity = 0
         if r.status_code:
                  ct = 0
                  for twitt in r.get_iterator():
                           if 'text' in twitt:
                                    try:
                                             ct+=1
                                             txt = TextBlob(twitt["text"])
                                             txt = txt.translate(to="en")
                                             polarity += txt.sentiment.polarity
                                             subjectivity += txt.sentiment.subjectivity
                                    except:
                                             ct -= 1
                  if ct <= 0:
                           polarity = "desconhecida"
                           subjectivity = "desconhecida"
                  else:
                           polarity = "{0:.2f}".format(polarity/ct)
                           subjectivity = "{0:.2f}".format(subjectivity/ct)
                  print("A polaridade do tema", tema, "é", polarity)
                  print("E a subjetividade é", subjectivity, '\n')
                  main()
main()
