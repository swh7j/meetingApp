import React, { Component } from 'react';
import { Carousel } from "react-bootstrap";
import main1 from '../img/main_1.png';
import main2 from '../img/main_2.png';
import main3 from '../img/main_3.png';
import main4 from '../img/main_4.png';
import main5 from '../img/main_5.png';

class Main extends Component {
    constructor(props) {
            super(props)

            this.state = {

            }
        }
    render() {
        return (
            <div className="container text-center">
                <Carousel>
                  <Carousel.Item>
                    <img
                      src={main1}
                      alt="First slide"
                      style={{'width':'80%'}}
                    />
                  </Carousel.Item>
                  <Carousel.Item>
                    <img
                      src={main2}
                      alt="Second slide"
                      style={{'width':'80%'}}
                    />
                  </Carousel.Item>
                  <Carousel.Item>
                    <img
                     src={main3}
                      alt="Third slide"
                      style={{'width':'80%'}}
                    />
                  </Carousel.Item>
                </Carousel>
            </div>
        );
    }
}

export default Main;