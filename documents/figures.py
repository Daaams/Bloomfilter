import matplotlib.pyplot as plt
import numpy as np

x = np.arange(30)

plt.figure()
# array
f1 = plt.subplot(2,2,1) #(nbLignes, nbColonnes, position sur la grille.) ici 2*2 du coup position = 1 ou 2 ou 3 ou 4
array = [5.184,5.078,5.024,5.158,5.099,5.068,5.052,5.075,5.034,5.079,4.994,5.029,5.519,5.098,5.035,5.216,5.126,5.148,5.081,5.046,5.056,5.057,5.176,5.088,5.092,5.076,5.018,5.06,5.067,5.167]
f1.plot(x, array)
f1.plot(x, np.array([np.mean(array) for i in range(30)]), label="mean")
f1.set_title("Benchmark Results Array")
f1.set_xlabel("Iterations")
f1.set_ylabel("ns/op")
f1.legend()
#ArrayList
f2 = plt.subplot(2,2,2)
ArrayList = [6.071,5.97,6.283,6.184,6.176,6.743,6.168,5.99,6.189,6.424,6.339,5.993,6.147,6.172,6.53,6.631,6.149,6.055,6.42,6.046,6.447,6.236,6.184,6.025,6.3,6.388,6.584,6.18,6.02,6.118]
f2.plot(x, ArrayList)
f2.plot(x, np.array([np.mean(ArrayList) for i in range(30)]), label="mean")
f2.set_title("Benchmark Results ArrayList")
f2.set_xlabel("Iterations")
f2.set_ylabel("ns/op")
f2.legend()
#LinkedList
f3 = plt.subplot(2,2,3)
LinkedList = [700.708,708.694,742.096,735.635,733.871,725.951,706.364,712.548,719.997,691.576,690.669,719.228,723.684,708.817,698.585,715.138,693.354,711.794,735.476,722.598,725.498,744.639,702.21,728.747,707.104,748.901,742.053,726.329,708.66,694.81]
f3.plot(x, LinkedList)
f3.plot(x, np.array([np.mean(LinkedList) for i in range(30)]), label ="mean")
f3.set_title("Benchmark Results LinkedList")
f3.set_xlabel("Iterations")
f3.set_ylabel("ns/op")
f3.legend()

f4 = plt.subplot(2,2,4)

f4.plot(x, [5.184,5.078,5.024,5.158,5.099,5.068,5.052,5.075,5.034,5.079,4.994,5.029,5.519,5.098,5.035,5.216,5.126,5.148,5.081,5.046,5.056,5.057,5.176,5.088,5.092,5.076,5.018,5.06,5.067,5.167], label="Array")
f4.plot(x, [6.071,5.97,6.283,6.184,6.176,6.743,6.168,5.99,6.189,6.424,6.339,5.993,6.147,6.172,6.53,6.631,6.149,6.055,6.42,6.046,6.447,6.236,6.184,6.025,6.3,6.388,6.584,6.18,6.02,6.118], label="ArrayList")
f4.plot(x, [700.708,708.694,742.096,735.635,733.871,725.951,706.364,712.548,719.997,691.576,690.669,719.228,723.684,708.817,698.585,715.138,693.354,711.794,735.476,722.598,725.498,744.639,702.21,728.747,707.104,748.901,742.053,726.329,708.66,694.81], label="LinkedList")
f4.set_title("Benchmark Results")
f4.set_xlabel("Iterations")
f4.set_ylabel("ns/op")
f4.legend()

plt.show()

#m=1000
plt.figure()
plt.title("Error Rate Array, k = 1")
# array, k = 1 
# n = 0.01
f5 =plt.subplot(3,1,1)
f5.set_title("Error Rate Array, k=1, m=1000, n=0.01")
f5.set_xlabel("Iterations")
f5.set_ylabel("error rate")
f5.plot(np.array(np.arange(20)), [0,0,0,0,0.001,0,0,0,0.001,0,0,0.001,0,0,0,0,0,0,0,0])
#n=0.05
f6 = plt.subplot(3,1,2)
f6.set_title("Error Rate Array, k=1, m=1000, n=0.05")
f6.set_xlabel("Iterations")
f6.set_ylabel("error rate")
f6.plot(np.array(np.arange(20)), [0.012,0.016,0.018,0.024,0.019,0.026,0.022,0.027,0.022,0.021,0.023,0.023,0.026,0.023,0.025,0.029,0.026,0.021,0.022,0.021])
#n=0.1
f7= plt.subplot(3,1,3)
f7.set_title("Error Rate Array, k=1, m=1000, n=0.1")
f7.set_xlabel("Iterations")
f7.set_ylabel("error rate")
f7.plot(np.array(np.arange(20)), [0.04,0.052,0.067,0.084,0.082,0.095,0.096,0.1,0.099,0.1,0.1,0.099,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1])
plt.show()

plt.figure()
plt.title("Error Rate Array, k = 3")
# array, k = 3 
# n = 0.01
f8 =plt.subplot(3,1,1)
f8.set_title("Error Rate Array, k=3, m=1000, n=0.01")
f8.set_xlabel("Iterations")
f8.set_ylabel("error rate")
f8.plot(np.array(np.arange(20)), [0,0,0,0.001,0,0.001,0,0,0.001,0,0.001,0,0,0,0,0,0,0.001,0,0])
#n=0.05
f9 = plt.subplot(3,1,2)
f9.set_title("Error Rate Array, k=3, m=1000, n=0.05")
f9.set_xlabel("Iterations")
f9.set_ylabel("error rate")
f9.plot(np.array(np.arange(20)), [0.013,0.019,0.024,0.027,0.019,0.031,0.026,0.026,0.023,0.024,0.021,0.025,0.028,0.027,0.024,0.027,0.029,0.023,0.026,0.02])
#n=0.1
f10= plt.subplot(3,1,3)
f10.set_title("Error Rate Array, k=3, m=1000, n=0.1")
f10.set_xlabel("Iterations")
f10.set_ylabel("error rate")
f10.plot(np.array(np.arange(20)), [0.068,0.094,0.097,0.098,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1])
plt.show()

plt.figure()
plt.title("Error Rate Array, k = 5")
# array, k = 5
# n = 0.01
f11 =plt.subplot(3,1,1)
f11.set_title("Error Rate Array, k=5, m=1000, n=0.01")
f11.set_xlabel("Iterations")
f11.set_ylabel("error rate")
f11.plot(np.array(np.arange(20)), [0,0,0,0,0.001,0,0,0,0,0,0,0.001,0,0,0,0.001,0.001,0,0,0])
#n=0.05
f12 = plt.subplot(3,1,2)
f12.set_title("Error Rate Array, k=5, m=1000, n=0.05")
f12.set_xlabel("Iterations")
f12.set_ylabel("error rate")
f12.plot(np.array(np.arange(20)), [0.015,0.019,0.022,0.027,0.023,0.025,0.025,0.024,0.021,0.021,0.026,0.025,0.026,0.025,0.031,0.031,0.029,0.029,0.022,0.022])
#n=0.1
f13= plt.subplot(3,1,3)
f13.set_title("Error Rate Array, k=5, m=1000, n=0.1")
f13.set_xlabel("Iterations")
f13.set_ylabel("error rate")
f13.plot(np.array(np.arange(20)), [0.065,0.098,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1])
plt.show()