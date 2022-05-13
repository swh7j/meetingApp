import React, { Component } from 'react';
import AcademyService from '../service/AcademyService';

class List extends Component {

    constructor(props) {
        super(props)
        this.state = { lists:[]}
    }

    componentDidMount() {
        AcademyService.getAcademy_list().then((res) => { this.setState({ lists: res.data }); });
    }

    render() {
        return (
            <div>
                <h2 className="text-center">학원 목록</h2>
                <div className ="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>학원 번호</th>
                                <th>학원 이름 </th>
                                <th> 담당 교육청 </th>
                            </tr>
                        </thead>
                       <tbody>
                        {console.log( this.state.lists)}
                           {
                               this.state.lists.map(
                                   (list) =>
                                   <tr key = {list}>
                                       <td> {list.id} </td>
                                       <td> {list.aca_NM} </td>
                                       <td> {list.atpt_OFCDC_SC_NM} </td>
                                   </tr>
                               )
                           }
                       </tbody>
                   </table>
                </div>
            </div>
        );
    }
}

export default List;