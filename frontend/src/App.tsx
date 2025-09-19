import React from "react";
import Filters from "./components/Filters";
import SetList from "./components/SetList";

export default function App() {
    const [filters, setFilters] = React.useState<Record<string, any>>({});
    return (
        <div style={{ padding: 20, fontFamily: "system-ui, sans-serif" }}>
            <h1>LEGO Sets Browser</h1>
            <Filters onChange={setFilters} />
            <SetList filters={filters} />
        </div>
    );
}
