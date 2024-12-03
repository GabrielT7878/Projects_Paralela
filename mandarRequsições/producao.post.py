import requests
import random
import datetime
import time

url = "http://127.0.0.1:8080/sendDadosProducao"

def gerar_body_dinamico(id):
    data = datetime.date(2024, 12, 1) + datetime.timedelta(days=id)
    
    tipos_cafe = [1, 2, 3] 
    qualidades = ["Alta", "Média", "Baixa"]
    cooperativas = [1, 2, 3, 4]

    return {
        "id": id,
        "data": data.isoformat(),
        "tipoCafeColhido": random.choice(tipos_cafe),
        "quantidadeColhida": round(random.uniform(100.0, 500.0), 1),
        "produtividade": round(random.uniform(80.0, 120.0), 1),
        "qualidade": random.choice(qualidades),
        "cooperativaId": random.choice(cooperativas)
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

