import './App.css';
import Home from './components/Home';
import About from './components/About'
import Work from './components/Work'

function App() {
  return (
    <div className="App">
        <div>
           <Home />
           <About />
           <Work />
        </div>
    </div>
  );
}

export default App;
