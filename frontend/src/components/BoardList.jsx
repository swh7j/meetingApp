import React, { Component } from 'react';
import BoardService from '../service/BoardService';

class List extends Component {


    constructor(props) {
        super(props)
        this.state = { lists:[]}
    }

    componentDidMount() {
            BoardService.get_boardlist().then((res) => { this.setState({ lists: res.data }); });
    }

    render() {
        return (
            <div>
                <h2 className="text-center">게시판</h2>
                <div className = "row">
                    <div className = "col-md-11">

                    </div>
                    <div className = "col-md-1">
                           <button className="btn btn-primary" onClick={this.createBoard}> 글 작성</button>
                    </div>
                </div>
                    <table className="table table-striped table-bordered">
                        <thead>
                             <tr>
                                <th>글 번호</th>
                                <th>타이틀 </th>
                                <th>작성자 </th>
                                <th>작성일 </th>
                                <th>갱신일 </th>
                                <th>좋아요수</th>
                                <th>조회수</th>
                            </tr>
                        </thead>
                       <tbody>
                        {console.log( this.state.lists)}
                           {
                               this.state.lists.map(
                                   (list) =>
                                   <tr key = {list}>
                                       <td> {list.b_id} </td>
                                       <td> {list.title} </td>
                                       <td> {list.m_num} </td>
                                       <td> {list.createdTime} </td>
                                       <td> {list.updatedTime} </td>
                                       <td> {list.b_like} </td>
                                       <td> {list.b_view} </td>
                                   </tr>
                               )
                           }
                       </tbody>
                   </table>
            </div>
        );
    }
}

export default List;