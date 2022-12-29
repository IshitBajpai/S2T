from vosk import Model,KaldiRecognizer
import pyaudio

# model =  Model(r"C:\Users\admin\Downloads\vosk-model-small-en-us-0.15\vosk-model-small-en-us-0.15")
model =  Model(r"vosk-model-small-en-us-0.15")
recognizer = KaldiRecognizer(model,16000)

mic = pyaudio.PyAudio()
stream = mic.open(format=pyaudio.paInt16,channels=1,rate=16000,input=True,frames_per_buffer=8192)
stream.start_stream()
def fib():
    print("stoping")
count = 0
while True:
    data = stream.read(4096)
    if recognizer.AcceptWaveform(data):
        text = recognizer.Result()
        print("Word #:",count)
        count+=1
        print(text[14:-3])
        if "stop" in text[14:-3]:
            fib()
            break

    