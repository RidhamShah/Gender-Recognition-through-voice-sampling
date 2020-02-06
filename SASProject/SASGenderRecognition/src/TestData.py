import sys
import matplotlib.pyplot as plt
import scipy.io.wavfile as wavfile
from scipy import fftpack
from scipy.fftpack import fft, fftfreq
from scipy.signal import decimate
import numpy as np

def stereo_to_mono(audiodata):
    return audiodata.sum(axis=1) / 2

def downsample(audiodata, factor):
    downsampled_data = decimate(audiodata, factor)
    return downsampled_data

def writefile(filename, value):
    f=open(filename,"w+")
    f.write(str(value))
    f.close() 


def execute(audiofile):
    samplerate, audiodata = wavfile.read(audiofile)
    
    audiodata = stereo_to_mono(audiodata)

    if samplerate>8000:
        audiodata = downsample(audiodata, (int)(samplerate / 8000))

    samplerate = 8000
    samples = audiodata.shape[0]
    # print(samples)
    # print(samplerate)

    datafft = fft(audiodata)
    ffttabs = abs(datafft)

    freq = fftfreq( samples, 1/samplerate )
    fr = freq[:int(freq.size/2)]

    y_fft = ffttabs[:int(freq.size/2)]
    sigma_I = 0
    for i in range(0, len(y_fft) ):
        if(i%100==0):
            sigma_I = sigma_I + y_fft[i]**2

    #print(sigma_I)

    sigma_IF = 0
    for i in range(0, len(fr)):
        if(i%100==0):
            sigma_IF = sigma_IF + ((y_fft[i]**2)*fr[i])

    #print(sigma_IF)

    thres = sigma_IF / sigma_I
    # print('vidish')
    # print(thres)

    return thres



# MAIN FUNCTION


s = 'F:\Studies\Sem-3\SignalAndSystems\SAS Project\TestDataSet\\Recording' + sys.argv[1] + '.wav'
avg_thres = execute(s)

writefile('F:\Studies\Sem-3\SignalAndSystems\SAS Project\TestDataSet\\AddData.txt', avg_thres)

file1 = open("F:\Studies\Sem-3\SignalAndSystems\SAS Project\DataFemale\\min_freq_female.txt","r")
s = file1.readlines()
min_freq_female = (float)(s[0])
min_freq_female /= 1
file1.close()

file1 = open("F:\Studies\Sem-3\SignalAndSystems\SAS Project\DataMale\\max_freq_male.txt","r")
s = file1.readlines()
max_freq_male = (float)(s[0])
max_freq_male /= 1
file1.close()

grey_lower = 0
grey_upper = 0

if(max_freq_male > min_freq_female):
    grey_lower = min_freq_female
    grey_upper = max_freq_male
else:
    grey_lower = max_freq_male
    grey_upper = min_freq_female

grey_lower = grey_lower - 50
grey_upper = grey_upper + 50

middle = (grey_lower + grey_upper) / 2

confidence = abs(middle - avg_thres) / ((float)(middle - grey_lower))
confidence = confidence * 100
if(confidence < 50):
    confidence = confidence + 50

if(avg_thres <= grey_lower):
    writefile('F:\Studies\Sem-3\SignalAndSystems\SAS Project\TestDataSet\\prediction.txt', 'MALE')
    writefile('F:\Studies\Sem-3\SignalAndSystems\SAS Project\TestDataSet\\confidence.txt', '100')
elif(avg_thres >= grey_upper):
    writefile('F:\Studies\Sem-3\SignalAndSystems\SAS Project\TestDataSet\\prediction.txt', 'FEMALE')
    writefile('F:\Studies\Sem-3\SignalAndSystems\SAS Project\TestDataSet\\confidence.txt', '100')
else:
    if(avg_thres == middle):
        writefile('F:\Studies\Sem-3\SignalAndSystems\SAS Project\TestDataSet\\prediction.txt', 'NOT ABLE TO TELL')
        writefile('F:\Studies\Sem-3\SignalAndSystems\SAS Project\TestDataSet\\confidence.txt', '0')
    elif(avg_thres < middle):
        writefile('F:\Studies\Sem-3\SignalAndSystems\SAS Project\TestDataSet\\prediction.txt', 'MALE')
        writefile('F:\Studies\Sem-3\SignalAndSystems\SAS Project\TestDataSet\\confidence.txt', round(confidence, 3))
    elif(avg_thres > middle):
        writefile('F:\Studies\Sem-3\SignalAndSystems\SAS Project\TestDataSet\\prediction.txt', 'FEMALE')
        writefile('F:\Studies\Sem-3\SignalAndSystems\SAS Project\TestDataSet\\confidence.txt', round(confidence, 3))


#OVER