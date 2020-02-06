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
file1 = open("F:\Studies\Sem-3\SignalAndSystems\SAS Project\DataFemale\\avg_thres_female.txt","r")
s = file1.readlines()
avg_thres = (float)(s[-1])
file1.close()

file1 = open("F:\Studies\Sem-3\SignalAndSystems\SAS Project\DataFemale\\total_num_of_data_female.txt","r")
s = file1.readlines()
total_files = (int)(s[0])
file1.close()

s = 'F:\Studies\Sem-3\SignalAndSystems\SAS Project\RecFilesFinalFemale\\' + sys.argv[1] + '.wav'
xx = execute(s)
avg_thres += xx
total_files = total_files + 1


#code to write total avg_thres sigma(fixi)
writefile('F:\Studies\Sem-3\SignalAndSystems\SAS Project\DataFemale\\avg_thres_female.txt', avg_thres)

#write sigma(fi)
writefile('F:\Studies\Sem-3\SignalAndSystems\SAS Project\DataFemale\\total_num_of_data_female.txt', total_files)


thres_freq = avg_thres / total_files

#write thres_freq
writefile('F:\Studies\Sem-3\SignalAndSystems\SAS Project\DataFemale\\thres_freq_female.txt', thres_freq)

f = open("F:\Studies\Sem-3\SignalAndSystems\SAS Project\DataFemale\\female_graph.txt", "a+")
ab = str(xx) + "\n"
f.write(ab)
f.close()

f = open('F:\Studies\Sem-3\SignalAndSystems\SAS Project\DataFemale\\min_freq_female.txt', 'r+')
x = f.readlines()
y = (float)(x[0])
if((float)(xx) < y):
    y = (float)(xx)

f.close()

f = open('F:\Studies\Sem-3\SignalAndSystems\SAS Project\DataFemale\\min_freq_female.txt', 'w+')
f.write((str)(y))
f.close()

#OVER