import requests
import random
import datetime
import time

url = "http://127.0.0.1:8080/sendDadosClima"

def gerar_body_dinamico(id):
    data_inicial = datetime.date(2024, 11, 20) + datetime.timedelta(days=id)
    data_final = data_inicial + datetime.timedelta(days=7)
    
    cidades_estados = [
        {"cidade": "São Paulo", "estado": "SP"},
        {"cidade": "Rio de Janeiro", "estado": "RJ"},
        {"cidade": "Belo Horizonte", "estado": "MG"},
        {"cidade": "Curitiba", "estado": "PR"},
        {"cidade": "Porto Alegre", "estado": "RS"}
    ]
    
    condicoes_climaticas = ["Nublado", "Ensolarado", "Chuvoso", "Tempestuoso", "Ventoso"]
    
    cidade_estado = random.choice(cidades_estados)
    
    return {
        "id": id,
        "dataInicial": data_inicial.isoformat(),
        "dataFinal": data_final.isoformat(),
        "cidade": cidade_estado["cidade"],
        "estado": cidade_estado["estado"],
        "umidadeMedia": round(random.uniform(50.0, 90.0), 1),
        "temperaturaMedia": round(random.uniform(15.0, 35.0), 1),
        "condicaoClima": random.choice(condicoes_climaticas)
    }

def enviar_requisicoes():
    while True:
        for i in range(400):
            body = gerar_body_dinamico(i + 1)
            try:
                response = requests.post(url, json=body)
                if response.status_code == 200:
                    print(f"Requisição {i+1} enviada com sucesso! Body: {body}")
                else:
                    print(f"Erro na requisição {i+1}: {response.status_code}, {response.text}")
            except Exception as e:
                print(f"Erro ao enviar requisição {i+1}: {str(e)}")
        time.sleep(2)   

if __name__ == "__main__":
    enviar_requisicoes()
